package com.cassbana.cashat.ui.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.cassbana.cashat.R
import com.cassbana.cashat.helper.LtrRtlDarkLightPreviews
import com.cassbana.cashat.helper.PinCreator
import com.cassbana.cashat.ui.theme.*

@Composable
fun PinCheck(onConfirmClick: () -> Unit = {}) {
    Column {
        Text(
            text = stringResource(id = R.string.checking_mobile),
            style = CassbanaTheme.typography.titleSecondary
        )
        var otp by rememberSaveable { mutableStateOf(0) }

        PinCreator(
            4,
            onConfirmClick = onConfirmClick,
            mutableListOf(2, 3, 5),
        )
        /** User can request a the second OTP after 30 seconds
         * User can request the 3rd OTP after 1 minute
         * User can request the fourth after 5 mins (up to 20 times)*/
    }
}

@LtrRtlDarkLightPreviews
@Composable
private fun DefaultPreview() {
    CassbanaTheme {
        PinCheck()
    }
}