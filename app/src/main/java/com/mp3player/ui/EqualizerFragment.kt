package com.mp3player.ui

import android.app.Dialog
import android.content.Context
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.mp3player.MainActivity
import com.mp3player.R
import com.mp3player.data.EqPreset
import com.mp3player.data.EqPresetManager
import com.mp3player.data.EqStateRepository
import com.mp3player.data.EqState
import com.mp3player.data.model.EqualizerBand
import com.mp3player.data.audio.EqualizerPresets
import com.mp3player.util.resolveThemeColor
import android.media.AudioDeviceInfo
import java.util.Locale

class EqualizerFragment : DialogFragment() {

    companion object {
        private const val BAND_COUNT = 10
        private const val CUSTOM_IDX = -1
        private const val DB_MIN = -24f
        private const val DB_MAX = 24f
        private const val DB_STEP = 0.5f
        private const val SEEK_MAX = ((DB_MAX - DB_MIN) / DB_STEP).toInt()
    }

    private var presetManager: EqPresetManager? = null
    private var audioManager: AudioManager? = null
    private var musicPlayer: com.mp3player.MusicPlayer? = null

    private val currentGains = FloatArray(BAND_COUNT) { 0f }
    private var currentPreamp = 0f
    private var currentPresetIdx = CUSTOM_IDX
    private var currentPresetName = "Flat"

    private lateinit var curveView: EqCurveView
    private lateinit var bandsContainer: LinearLayout
    private lateinit var presetNameLabel: TextView
    private lateinit var preampValue: TextView
    private lateinit var preampSeek: SeekBar
    private lateinit var eqToggle: Button
    private lateinit var limiterIndicator: TextView
    private val limiterHandler = Handler(Looper.getMainLooper())
    private var restoringEqState = false
    private var isInitialized = false
    private var initRunnable: Runnable? = null
    private val limiterRunnable = object : Runnable {
        override fun run() {
            updateLimiterDisplay()
            limiterHandler.postDelayed(this, 250)
        }
    }

    private val filePicker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) loadPresetFromFile(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_NoTitleBar_Fullscreen)
    }

    override fun onResume() {
        super.onResume()
        limiterHandler.post(limiterRunnable)
        if (!isInitialized) {
            initializeEq()
        }
    }

    override fun onPause() {
        super.onPause()
        limiterHandler.removeCallbacks(limiterRunnable)
        initRunnable?.let { limiterHandler.removeCallbacks(it) }
        saveState()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.let { w ->
            w.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            w.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_equalizer, container, false)
        curveView = v.findViewById(R.id.eq_curve_view)
        bandsContainer = v.findViewById(R.id.bands_container)
        presetNameLabel = v.findViewById(R.id.tv_preset_name)
        preampValue = v.findViewById(R.id.tv_preamp_value)
        preampSeek = v.findViewById(R.id.seek_preamp)
        eqToggle = v.findViewById(R.id.btn_eq_toggle)
        limiterIndicator = v.findViewById(R.id.tv_limiter)

        presetManager = EqPresetManager(requireContext())
        audioManager = requireContext().getSystemService(Context.AUDIO_SERVICE) as AudioManager
        musicPlayer = (activity as? MainActivity)?.playerService?.musicPlayer

        eqToggle.setOnClickListener {
            if (!restoringEqState) toggleEq(!eqToggle.isSelected)
        }

        v.findViewById<Button>(R.id.btn_save_eq).setOnClickListener { showSaveDialog() }
        v.findViewById<Button>(R.id.btn_reset_eq).setOnClickListener { resetAllBands() }
        v.findViewById<Button>(R.id.btn_recarregar).setOnClickListener { filePicker.launch("application/json") }
        v.findViewById<View>(R.id.knob_presets_area).setOnClickListener { showPresetsDialog() }
        v.findViewById<View>(R.id.knob_presets_area).setOnLongClickListener { showCustomPresetsDialog(); true }
        v.findViewById<View>(R.id.btn_prev_preset).setOnClickListener { prevPreset() }
        v.findViewById<View>(R.id.btn_next_preset).setOnClickListener { nextPreset() }
        v.findViewById<View>(R.id.btn_close_eq)?.setOnClickListener { dismiss() }

        setupPreampSeek()
        rebuildBands()

        return v
    }

    private fun setupPreampSeek() {
        preampSeek.max = SEEK_MAX
        preampSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (!fromUser) return
                currentPreamp = progressToDb(progress)
                preampValue.text = formatGain(currentPreamp)
                musicPlayer?.setPreamp(currentPreamp)
                updateCurveView()
                debounceSave()
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })
    }

    private fun initializeEq() {
        initRunnable?.let { limiterHandler.removeCallbacks(it) }
        val mp = musicPlayer ?: (activity as? MainActivity)?.playerService?.musicPlayer
        musicPlayer = mp
        if (mp == null) {
            initRunnable = Runnable { initializeEq() }
            limiterHandler.postDelayed(initRunnable!!, 500)
            return
        }

        // Migrate from old format if needed
        val migrated = EqStateRepository.migrateFromOldFormat(requireContext(), audioManager!!)
        if (migrated != null) {
            applyState(migrated)
        } else {
            // Load current device state
            val state = EqStateRepository.loadForCurrentDevice(requireContext(), audioManager!!)
            applyState(state)
        }

        isInitialized = true
    }

    private fun applyState(state: EqState) {
        restoringEqState = true
        currentPreamp = state.preamp
        currentPresetIdx = state.presetIdx
        currentPresetName = state.presetName
        for (i in 0 until BAND_COUNT) {
            currentGains[i] = state.gains.getOrElse(i) { 0f }
        }

        val mp = musicPlayer
        mp?.let {
            it.setPreamp(currentPreamp)
            for (i in 0 until BAND_COUNT) {
                it.setBandGain(i, currentGains[i])
            }
            it.setEnabled(state.enabled)
        }

        eqToggle.isSelected = state.enabled
        eqToggle.text = if (state.enabled) "EQ ON" else "EQ OFF"
        eqToggle.setBackgroundResource(if (state.enabled) R.drawable.bg_preset_active else R.drawable.bg_preset_btn)
        eqToggle.setTextColor(if (state.enabled) 0xFF00BFFF.toInt() else 0xFFB0B0B0.toInt())

        preampSeek.progress = dbToProgress(currentPreamp)
        preampValue.text = formatGain(currentPreamp)

        updatePresetNameDisplay(currentPresetName)
        rebuildBands()
        updateCurveView()
        restoringEqState = false
    }

    private fun rebuildBands() {
        // Recycle views instead of recreating
        val childCount = bandsContainer.childCount
        for (i in 0 until BAND_COUNT) {
            val row: LinearLayout
            if (i < childCount) {
                row = bandsContainer.getChildAt(i) as LinearLayout
            } else {
                row = LinearLayout(requireContext())
                row.orientation = LinearLayout.VERTICAL
                row.gravity = Gravity.CENTER_HORIZONTAL
                val lp = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f)
                lp.setMargins(8, 4, 8, 4)
                row.layoutParams = lp
                bandsContainer.addView(row)
            }
            updateBandRow(row, i)
        }
        // Remove excess views
        while (bandsContainer.childCount > BAND_COUNT) {
            bandsContainer.removeViewAt(bandsContainer.childCount - 1)
        }
    }

    private fun updateBandRow(row: LinearLayout, bandIdx: Int) {
        // Update label
        val freq = EqualizerBand.FREQUENCIES[bandIdx]
        val label = row.getChildAt(0) as TextView
        label.text = if (freq >= 1000f) "%.0fk".format(freq / 1000f) else "%.0f".format(freq)

        // Update seekbar
        val seek = row.getChildAt(1) as SeekBar
        seek.max = SEEK_MAX
        seek.progress = dbToProgress(currentGains[bandIdx])
        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (!fromUser) return
                val g = progressToDb(progress)
                currentGains[bandIdx] = g
                val valueText = row.getChildAt(2) as TextView
                valueText.text = formatGain(g)
                valueText.setTextColor(gainColor(g))
                musicPlayer?.setBandGain(bandIdx, g)
                if (currentPresetIdx != CUSTOM_IDX) {
                    currentPresetIdx = CUSTOM_IDX
                    updatePresetNameDisplay("Customizado")
                }
                updateCurveView()
                debounceSave()
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        // Update value text
        val valueText = row.getChildAt(2) as TextView
        valueText.text = formatGain(currentGains[bandIdx])
        valueText.setTextColor(gainColor(currentGains[bandIdx]))
    }

    private fun addBandRow(bandIdx: Int) {
        val row = LinearLayout(requireContext())
        row.orientation = LinearLayout.VERTICAL
        row.gravity = Gravity.CENTER_HORIZONTAL
        val lp = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f)
        lp.setMargins(8, 4, 8, 4)
        row.layoutParams = lp

        val freq = EqualizerBand.FREQUENCIES[bandIdx]
        val label = TextView(requireContext())
        label.text = if (freq >= 1000f) "%.0fk".format(freq / 1000f) else "%.0f".format(freq)
        label.setTextColor(requireContext().resolveThemeColor(R.attr.themeTextSecondary))
        label.textSize = 10f
        label.typeface = android.graphics.Typeface.DEFAULT_BOLD
        label.gravity = Gravity.CENTER_HORIZONTAL
        label.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            .apply { setMargins(0, 0, 0, 2) }
        row.addView(label)

        val seek = SeekBar(requireContext(), null, android.R.attr.seekBarStyle)
        seek.max = SEEK_MAX
        seek.progress = dbToProgress(currentGains[bandIdx])
        seek.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f)
        try { seek.progressDrawable = resources.getDrawable(R.drawable.seekbar_v_track, null) } catch (_: Exception) {}
        try { seek.thumb = resources.getDrawable(R.drawable.seekbar_v_thumb, null) } catch (_: Exception) {}
        row.addView(seek)

        val valueText = TextView(requireContext())
        valueText.text = formatGain(currentGains[bandIdx])
        valueText.setTextColor(gainColor(currentGains[bandIdx]))
        valueText.textSize = 10f
        valueText.typeface = android.graphics.Typeface.DEFAULT_BOLD
        valueText.gravity = Gravity.CENTER_HORIZONTAL
        valueText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            .apply { setMargins(0, 2, 0, 0) }
        row.addView(valueText)

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (!fromUser) return
                val g = progressToDb(progress)
                currentGains[bandIdx] = g
                valueText.text = formatGain(g)
                valueText.setTextColor(gainColor(g))
                musicPlayer?.setBandGain(bandIdx, g)
                if (currentPresetIdx != CUSTOM_IDX) {
                    currentPresetIdx = CUSTOM_IDX
                    updatePresetNameDisplay("Customizado")
                }
                updateCurveView()
                debounceSave()
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        bandsContainer.addView(row)
    }

    private fun updateCurveView() {
        curveView.levels = currentGains.clone()
    }

    private fun toggleEq(on: Boolean) {
        eqToggle.isSelected = on
        eqToggle.text = if (on) "EQ ON" else "EQ OFF"
        eqToggle.setBackgroundResource(if (on) R.drawable.bg_preset_active else R.drawable.bg_preset_btn)
        eqToggle.setTextColor(if (on) 0xFF00BFFF.toInt() else 0xFFB0B0B0.toInt())
        musicPlayer?.setEnabled(on)
    }

    private fun updateLimiterDisplay() {
        val mp = musicPlayer
        val reduction = mp?.gainReductionDb ?: 0f
        if (reduction < -0.5f) {
            limiterIndicator.text = "LIM: ${"%.1f".format(reduction)} dB"
            limiterIndicator.setTextColor(if (reduction < -3f) 0xFFFF5252.toInt() else 0xFFFFEB3B.toInt())
        } else {
            limiterIndicator.text = "LIM: 0.0 dB"
            limiterIndicator.setTextColor(0xFF66BB6A.toInt())
        }
    }

    private fun dbToProgress(db: Float): Int {
        return Math.round((db - DB_MIN) / DB_STEP).coerceIn(0, SEEK_MAX)
    }

    private fun progressToDb(progress: Int): Float {
        return (progress * DB_STEP + DB_MIN).coerceIn(DB_MIN, DB_MAX)
    }

    private fun formatGain(g: Float): String = if (g > 0) "+${"%.1f".format(g)}" else "%.1f".format(g)

    private fun gainColor(g: Float): Int = when {
        g > 0.5f -> 0xFF00E676.toInt()
        g < -0.5f -> 0xFFFF5252.toInt()
        else -> 0xFFB0B0B0.toInt()
    }

    private fun resetAllBands() {
        for (i in 0 until BAND_COUNT) currentGains[i] = 0f
        currentPreamp = 0f
        musicPlayer?.reset()
        currentPresetIdx = CUSTOM_IDX
        updatePresetNameDisplay("Customizado")
        preampSeek.progress = dbToProgress(0f)
        preampValue.text = formatGain(0f)
        rebuildBands()
        updateCurveView()
        saveState()
        Toast.makeText(context, "Equalizador reiniciado", Toast.LENGTH_SHORT).show()
    }

    private fun applyPreset(gains: FloatArray, preamp: Float, name: String) {
        currentPreamp = preamp
        val maxV = minOf(gains.size, currentGains.size)
        for (v in 0 until maxV) {
            currentGains[v] = gains[v]
        }
        musicPlayer?.let { mp ->
            mp.applyPreset(gains, preamp)
        }
        updatePresetNameDisplay(name)
        rebuildBands()
        updateCurveView()
        preampSeek.progress = dbToProgress(preamp)
        preampValue.text = formatGain(preamp)
        saveState()
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show()
    }

    private fun updatePresetNameDisplay(name: String) {
        currentPresetName = name
        if (::presetNameLabel.isInitialized) presetNameLabel.text = name
    }

    private fun applyPresetByIndex(idx: Int) {
        if (idx < 0 || idx >= EqualizerPresets.presets.size) return
        currentPresetIdx = idx
        val p = EqualizerPresets.presets[idx]
        applyPreset(p.gains, p.preamp, p.name)
    }

    private fun nextPreset() {
        var idx = currentPresetIdx
        if (idx == CUSTOM_IDX) idx = 0 else idx = (idx + 1) % EqualizerPresets.presets.size
        applyPresetByIndex(idx)
    }

    private fun prevPreset() {
        var idx = currentPresetIdx
        if (idx == CUSTOM_IDX) idx = 0 else idx = if (idx == 0) EqualizerPresets.presets.size - 1 else idx - 1
        applyPresetByIndex(idx)
    }

    private var saveDebounceRunnable: Runnable? = null
    private fun debounceSave() {
        saveDebounceRunnable?.let { limiterHandler.removeCallbacks(it) }
        saveDebounceRunnable = Runnable { saveState() }
        limiterHandler.postDelayed(saveDebounceRunnable!!, 500)
    }

    private fun saveState() {
        val mp = musicPlayer
        // Get current device info for persistence
        val devices = audioManager?.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        val primaryDevice = devices?.firstOrNull { it.type != AudioDeviceInfo.TYPE_UNKNOWN }
        val deviceType = primaryDevice?.type ?: AudioDeviceInfo.TYPE_BUILTIN_SPEAKER
        val deviceId = primaryDevice?.id ?: 0

        val state = EqState(
            gains = currentGains.clone(),
            preamp = currentPreamp,
            presetIdx = currentPresetIdx,
            presetName = currentPresetName,
            enabled = eqToggle.isSelected,
            deviceType = deviceType,
            deviceId = deviceId
        )
        EqStateRepository.save(requireContext(), state)
    }

    private fun showPresetsDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Predefinições")
            .setItems(EqualizerPresets.presets.map { it.name }.toTypedArray()) { _, which ->
                applyPresetByIndex(which)
            }
            .setNeutralButton("Cancelar", null).show()
    }

    private fun showCustomPresetsDialog(): Boolean {
        val presets = presetManager?.loadCustomPresets() ?: return false
        if (presets.isEmpty()) { Toast.makeText(context, "Nenhum preset salvo", Toast.LENGTH_SHORT).show(); return false }
        AlertDialog.Builder(requireContext())
            .setTitle("Meus Presets")
            .setItems(presets.map { it.name }.toTypedArray()) { _, which ->
                currentPresetIdx = CUSTOM_IDX
                val p = presets[which]
                applyPreset(p.gains, p.preamp, p.name)
            }
            .setNeutralButton("Cancelar", null).show()
        return true
    }

    private fun loadPresetFromFile(uri: Uri) {
        try {
            val input = requireContext().contentResolver.openInputStream(uri) ?: return
            val json = input.bufferedReader().use { it.readText() }
            val root = org.json.JSONObject(json)
            val gainsArr = root.getJSONArray("bands")
            val gains: FloatArray
            if (gainsArr.length() > 0 && gainsArr.get(0) is Number) {
                gains = FloatArray(gainsArr.length()) { gainsArr.getDouble(it).toFloat() }
            } else {
                gains = FloatArray(gainsArr.length()) { gainsArr.getJSONObject(it).getDouble("gain").toFloat() }
            }
            val preamp = root.optDouble("preamp", 0.0).toFloat()
            applyPreset(gains, preamp, root.optString("preset", root.optString("name", "Arquivo")))
        } catch (e: Exception) { Toast.makeText(context, "Erro ao carregar arquivo", Toast.LENGTH_SHORT).show() }
    }

    private fun showSaveDialog() {
        val input = EditText(requireContext())
        input.setHint("Nome do preset")
        input.setTextColor(requireContext().resolveThemeColor(R.attr.themeTextPrimary))
        input.setHintTextColor(requireContext().resolveThemeColor(R.attr.themeTextSecondary))
        AlertDialog.Builder(requireContext())
            .setTitle("Salvar como Preset")
            .setView(input)
            .setPositiveButton("Salvar") { _, _ ->
                val name = input.text.toString().trim()
                if (name.isEmpty()) { Toast.makeText(context, "Nome inválido", Toast.LENGTH_SHORT).show(); return@setPositiveButton }
                presetManager?.addOrUpdatePreset(EqPreset(name, currentGains.clone(), currentPreamp))
                Toast.makeText(context, "Preset \"$name\" salvo", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveDebounceRunnable?.let { limiterHandler.removeCallbacks(it) }
        initRunnable?.let { limiterHandler.removeCallbacks(it) }
        limiterHandler.removeCallbacks(limiterRunnable)
    }
}