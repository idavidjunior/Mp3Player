package com.mp3player

import android.graphics.Bitmap
import com.mp3player.data.PlayCountManager

interface PlayerHost {
    val playerService: PlayerService?
    val playCountManager: PlayCountManager
    fun playNext()
    fun playPrevious()
    fun openTagEditor(song: Song)
    fun loadSongs()
    fun hasRequiredPermission(): Boolean
    fun getCachedBitmap(path: String): Bitmap?
    fun putCachedBitmap(path: String, bitmap: Bitmap)
}
