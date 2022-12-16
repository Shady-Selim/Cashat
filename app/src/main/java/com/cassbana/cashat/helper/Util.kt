package com.cassbana.cashat.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.lokalise.sdk.Lokalise
import com.lokalise.sdk.LokaliseResources

object Util {
    @Composable
    fun getString(key: String): String? {
        Lokalise.setLocale("ar", "", "", LocalContext.current)
        val lokaliseResources = LokaliseResources(LocalContext.current)
        return lokaliseResources.getString(key)
    }
}