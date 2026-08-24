package com.mp3player.data

import android.content.Context
import android.media.AudioManager
import com.mp3player.MusicPlayer

object EqStateLoader {

    fun restoreTo(mp: MusicPlayer, context: Context, audioManager: AudioManager) {
        // Migrate from old format if needed
        val migrated = EqStateRepository.migrateFromOldFormat(context, audioManager)
        if (migrated != null) {
            mp.restoreState(migrated.gains, migrated.preamp, migrated.enabled)
            return
        }

        // Load current device state
        val state = EqStateRepository.loadForCurrentDevice(context, audioManager)
        mp.restoreState(state.gains, state.preamp, state.enabled)

        // Efeitos de motor e reproducao; 0/ausente = neutro (Gson deixa 0 em JSON antigo)
        mp.setEqEffects(state.bassBoost, state.stereoWidth, state.reverbMix)
        if (state.transitionFadeMs > 0) mp.transitionFadeMs = state.transitionFadeMs
        if (state.playbackSpeed > 0f && state.playbackSpeed != 1f) {
            mp.setPlaybackSpeed(state.playbackSpeed)
        }
    }
}