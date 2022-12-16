package com.cassbana.cashat.helper

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL, locale = "ar", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL, locale = "ar", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL, locale = "en", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL, locale = "en", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class LtrRtlDarkLightPreviews