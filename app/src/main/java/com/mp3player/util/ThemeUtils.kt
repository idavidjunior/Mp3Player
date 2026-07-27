package com.mp3player.util

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes

fun Context.resolveThemeColor(@AttrRes attrRes: Int): Int {
    val tv = TypedValue()
    if (theme.resolveAttribute(attrRes, tv, true)) {
        return tv.data
    }
    return 0
}
