package com.mp3player.data.model

data class EqualizerBand(
    val id: Int,
    val centerFrequencyHz: Float,
    var gainDb: Float = 0f,
    val q: Float = 1.414f
) {
    val label: String
        get() = when {
            centerFrequencyHz >= 1000f -> "%.0fk".format(centerFrequencyHz / 1000f)
            else -> "%.0f".format(centerFrequencyHz)
        }

    companion object {
        val BAND_COUNT = 10
        val FREQUENCIES = floatArrayOf(
            31.5f, 63f, 125f, 250f, 500f,
            1000f, 2000f, 4000f, 8000f, 16000f
        )
        val DEFAULT_Q = 1.414f

        fun createDefaultBands(): List<EqualizerBand> =
            FREQUENCIES.mapIndexed { index, freq -> EqualizerBand(index, freq, 0f, DEFAULT_Q) }
    }
}
