package com.mp3player.data

import android.content.Context
import android.content.SharedPreferences
import android.media.AudioDeviceInfo
import android.media.AudioManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mp3player.data.model.EqualizerBand
import java.lang.reflect.Type
import java.util.Locale

data class EqState(
    val version: Int = 3,
    val gains: FloatArray = FloatArray(EqualizerBand.BAND_COUNT) { 0f },
    val preamp: Float = 0f,
    val presetIdx: Int = -1,
    val presetName: String = "Flat",
    val enabled: Boolean = true,
    val deviceType: Int = AudioDeviceInfo.TYPE_BUILTIN_SPEAKER,
    val deviceId: Int = 0,
    val timestamp: Long = System.currentTimeMillis()
)

object EqStateRepository {

    private const val PREFS_NAME = "eq_state_v3"
    private const val KEY_PREFIX = "eq_state_"
    private val gson = Gson()
    private val typeToken: Type = object : TypeToken<EqState>() {}.type

    private fun getKey(deviceType: Int, deviceId: Int): String {
        return "$KEY_PREFIX${deviceType}_$deviceId"
    }

    fun save(context: Context, state: EqState) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = gson.toJson(state)
        prefs.edit()
            .putString(getKey(state.deviceType, state.deviceId), json)
            .apply()
    }

    fun load(context: Context, deviceType: Int, deviceId: Int): EqState? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(getKey(deviceType, deviceId), null)
        return json?.let { gson.fromJson(it, typeToken) as EqState? }
    }

    fun loadForCurrentDevice(context: Context, audioManager: AudioManager): EqState {
        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        val primaryDevice = devices.firstOrNull { it.type != AudioDeviceInfo.TYPE_UNKNOWN }
            ?: return EqState()

        val state = load(context, primaryDevice.type, primaryDevice.id)
        return state ?: EqState(deviceType = primaryDevice.type, deviceId = primaryDevice.id)
    }

    fun loadAll(context: Context): Map<String, EqState> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val map = mutableMapOf<String, EqState>()
        prefs.all.forEach { (key, value) ->
            if (key.startsWith(KEY_PREFIX) && value is String) {
                try {
                    val state = gson.fromJson(value, typeToken) as EqState
                    map[key] = state
                } catch (_: Exception) {}
            }
        }
        return map
    }

    fun delete(context: Context, deviceType: Int, deviceId: Int) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().remove(getKey(deviceType, deviceId)).apply()
    }

    fun migrateFromOldFormat(context: Context, audioManager: AudioManager): EqState? {
        val oldPrefs = context.getSharedPreferences("eq_active_state", Context.MODE_PRIVATE)
        val gainsStr = oldPrefs.getString("gains", null) ?: return null

        val version = oldPrefs.getInt("format_version", 1)
        val preamp = oldPrefs.getFloat("preamp", 0f)
        val presetIdx = oldPrefs.getInt("preset_idx", -1)
        val presetName = oldPrefs.getString("preset_name", "Flat") ?: "Flat"
        val enabled = oldPrefs.getBoolean("eq_enabled", true)

        val rawParts = if (gainsStr.contains("|")) {
            gainsStr.split("\\|".toRegex())
        } else {
            gainsStr.split(",")
        }

        val parts: List<String>
        if (version < 2 && rawParts.size > EqualizerBand.BAND_COUNT + 5) {
            val fixed = mutableListOf<String>()
            for (j in rawParts.indices step 2) {
                val intPart = rawParts[j]
                val decPart = rawParts.getOrElse(j + 1) { "0" }
                fixed.add("$intPart.$decPart")
            }
            parts = fixed
        } else {
            parts = rawParts
        }

        val gains = FloatArray(EqualizerBand.BAND_COUNT) { 0f }
        for (i in 0 until minOf(parts.size, EqualizerBand.BAND_COUNT)) {
            var g = parts[i].toFloatOrNull() ?: continue
            // Old format stored gains with preamp already applied, so subtract preamp
            if (version < 2) g -= preamp
            gains[i] = g.coerceIn(-24f, 24f)
        }

        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        val primaryDevice = devices.firstOrNull { it.type != AudioDeviceInfo.TYPE_UNKNOWN }
            ?: return EqState(gains = gains, preamp = preamp, presetIdx = presetIdx, presetName = presetName, enabled = enabled)

        val state = EqState(
            gains = gains,
            preamp = preamp,
            presetIdx = presetIdx,
            presetName = presetName,
            enabled = enabled,
            deviceType = primaryDevice.type,
            deviceId = primaryDevice.id
        )
        save(context, state)
        return state
    }
}