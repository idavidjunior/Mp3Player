package com.mp3player.data.audio

object EqualizerPresets {

    data class Preset(
        val name: String,
        val gains: FloatArray,
        val preamp: Float = 0f
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is Preset) return false
            return name == other.name && gains.contentEquals(other.gains) && preamp == other.preamp
        }
        override fun hashCode(): Int = name.hashCode() * 31 + gains.contentHashCode() + preamp.hashCode()
    }

    // 10 bandas ISO: [31.5, 63, 125, 250, 500, 1000, 2000, 4000, 8000, 16000] Hz
    // Preamps calibrados para que ganho efetivo máximo não exceda ~+6dB (headroom para limiter)
    val presets = listOf(
        Preset("Flat", floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f), 0f),
        Preset("Bass Boost", floatArrayOf(6f, 4f, 2f, 1f, 0f, 0f, 0f, 0f, 0f, 0f), -6f),
        Preset("Treble Boost", floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 1f, 2f, 4f, 6f), -6f),
        Preset("V-Shape", floatArrayOf(4f, 3f, 1f, 0f, -2f, -2f, 0f, 1f, 3f, 4f), -4f),
        Preset("Rock", floatArrayOf(3f, 2f, 1f, 0f, -2f, -3f, -2f, 0f, 1f, 3f), -3f),
        Preset("Pop", floatArrayOf(1f, 1f, 2f, 3f, 4f, 3f, 2f, 1f, 0f, 0f), -4f),
        Preset("Jazz", floatArrayOf(2f, 2f, 1f, 0f, 0f, 0f, 0f, 1f, 2f, 3f), -3f),
        Preset("Clássica", floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f, 1f, 2f), 0f),
        Preset("Eletrônica", floatArrayOf(4f, 4f, 3f, 2f, 0f, -1f, -1f, 0f, 2f, 4f), -5f),
        Preset("Hip-Hop", floatArrayOf(5f, 4f, 3f, 2f, 0f, 0f, 0f, 0f, 0f, 0f), -5f),
        Preset("Vocal", floatArrayOf(0f, 0f, 0f, 0f, 1f, 3f, 4f, 3f, 1f, 0f), -4f),
        Preset("Acústico", floatArrayOf(2f, 2f, 2f, 1f, 0f, 0f, 0f, 1f, 2f, 2f), -3f),
        Preset("Loudness", floatArrayOf(8f, 6f, 4f, 2f, 1f, 0f, 0f, 1f, 3f, 5f), -8f),
        Preset("Carro", floatArrayOf(4f, 3f, 2f, 1f, -1f, -2f, -2f, -1f, 0f, 1f), -4f),
        Preset("Fone de Ouvido", floatArrayOf(3f, 3f, 2f, 1f, 0f, 0f, 0f, 1f, 3f, 3f), -3f),
    )

    fun getPresetByName(name: String): Preset? = presets.find { it.name == name }
}