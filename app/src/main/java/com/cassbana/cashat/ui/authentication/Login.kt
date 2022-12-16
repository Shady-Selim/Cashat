package com.cassbana.cashat.ui.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import com.cassbana.cashat.R
import com.cassbana.cashat.helper.LtrRtlDarkLightPreviews
import com.cassbana.cashat.helper.MaskVisualTransformation
import com.cassbana.cashat.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    onRegisterClick: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf("") }
    val trailingIconView = @Composable {
        Image(
            painter = painterResource(id = R.drawable.egypt),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(54.dp)
                .width(105.dp)
                .padding(horizontal = 16.dp)
        )
    }

    Column {
        Text(
            text = stringResource(id = R.string.welcome),//Util.getString("welcome")!!,
            style = CassbanaTheme.typography.titleMain
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.write_mobile),
            style = CassbanaTheme.typography.paragraph2,
            color = Neutral6
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = text,
            onValueChange = {
                if (it.length <= 11) {
                    text = it
                }
            },
            label = {
                Text(
                    stringResource(id = R.string.mobile_number),
                    style = CassbanaTheme.typography.paragraph2
                )
            },
            textStyle = TextStyle(textDirection = TextDirection.Ltr),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            trailingIcon = trailingIconView,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    stringResource(id = R.string.mobile_hint),
                    style = CassbanaTheme.typography.paragraph2,
                    color = Neutral6,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            },
            visualTransformation = MaskVisualTransformation("### #### ####")
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { onRegisterClick(text) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = RoyalBlue1,
                disabledContainerColor = Neutral2, disabledContentColor = Neutral5
            ),
            enabled = text.length == 11
        ) {
            Text(
                text = stringResource(id = R.string.register),
                style = CassbanaTheme.typography.actionButton
            )
        }
    }
}

@LtrRtlDarkLightPreviews
@Composable
private fun DefaultPreview() {
    CassbanaTheme {
        Login()
    }
}