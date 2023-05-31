package com.example.dofavour.android.core.utils

import android.content.Context

sealed class UiText {
    data class DynamicString(val text: String): UiText()
    data class StringResource(val resId: Int): UiText()

    fun asString(context: Context): String =
        when(this) {
            is DynamicString -> text
            is StringResource -> context.getString(resId)
        }
}