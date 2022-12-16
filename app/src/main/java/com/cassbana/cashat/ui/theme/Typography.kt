package com.cassbana.cashat.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class TajawalTypography(
    val titleXL: TextStyle,
    val titleMain: TextStyle,
    val titleSecondary: TextStyle,
    val titleTertiary: TextStyle,
    val actionButton: TextStyle,
    val paragraph1: TextStyle,
    val paragraph2: TextStyle,
    val helpText1: TextStyle,
    val helpText2: TextStyle,
    val labelText: TextStyle
)

val LocalReplacementTypography = staticCompositionLocalOf {
    TajawalTypography(
        titleXL = TextStyle.Default,
        titleMain = TextStyle.Default,
        titleSecondary = TextStyle.Default,
        titleTertiary = TextStyle.Default,
        actionButton = TextStyle.Default,
        paragraph1 = TextStyle.Default,
        paragraph2 = TextStyle.Default,
        helpText1 = TextStyle.Default,
        helpText2 = TextStyle.Default,
        labelText = TextStyle.Default
    )
}

val tajawalTypography = TajawalTypography(
    titleXL = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 72.sp
    ),
    titleMain = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 48.sp
    ),
    titleSecondary = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 44.sp
    ),
    titleTertiary = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 32.sp
    ),
    actionButton = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    paragraph1 = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    paragraph2 = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    helpText1 = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    helpText2 = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 22.sp
    ),
    labelText = TextStyle(
        fontFamily = tajawalFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 20.sp
    )
)