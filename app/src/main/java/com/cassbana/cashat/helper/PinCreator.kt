package com.cassbana.cashat.helper

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.cassbana.cashat.R
import com.cassbana.cashat.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun PinCreator(length: Int, onConfirmClick: () -> Unit, list: List<Int>) {
    var otp by remember { mutableStateOf("") }
    var listIndex by remember { mutableStateOf(0) }
    val waitingSecList: MutableList<Int> = list.toMutableList()
    waitingSecList.add(0)
    var ticks by remember { mutableStateOf(waitingSecList[listIndex++]) }
    Text(
        buildAnnotatedString {
            append(stringResource(id = R.string.pin_sent))
            withStyle(style = SpanStyle(color = RoyalBlue1)) {
                append(" $ticks ")
                append(stringResource(id = R.string.seconds))
            }
        },
        style = CassbanaTheme.typography.paragraph2,
        color = Neutral6,
        modifier = Modifier
            .padding(top = 8.dp)
            .width(260.dp)
    )
    Spacer(modifier = Modifier.height(24.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
        for (i in 1..length) {
            val focusManager = LocalFocusManager.current
            val focusRequester = remember { FocusRequester() }
            var text by remember { mutableStateOf("") }
            var enabled by remember { mutableStateOf(true) }
            BasicTextField(value = text, onValueChange = {
                text = it
                otp += it
                enabled = false
                focusManager.moveFocus(FocusDirection.Previous)
            },
                modifier = Modifier
                    .border(
                        1.dp,
                        Neutral4, MaterialTheme.shapes.small
                    )
                    .height(56.dp)
                    .weight(1f)
                    .focusRequester(focusRequester = focusRequester),
                textStyle = TextStyle(textAlign = TextAlign.Center),
                enabled = enabled,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = if (otp.length < length) ImeAction.Next else ImeAction.Done
                ),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.Center) {
                        if (text.isEmpty()) {
                            Text(
                                text = "0",
                                style = CassbanaTheme.typography.actionButton,
                                color = Neutral6
                            )
                        } else {
                            Text(text = text, style = CassbanaTheme.typography.paragraph2)
                        }
                        innerTextField()
                    }
                }
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    if (listIndex < waitingSecList.size) {
        TextButton(
            onClick = { ticks = waitingSecList[listIndex++] },
            enabled = ticks == 0
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.resend_code),
                    style = CassbanaTheme.typography.helpText1,
                    color = if (ticks == 0) RoyalBlue1 else Neutral4
                )
                if (ticks == 0) {
                    Divider(
                        color = RoyalBlue1, thickness = 1.dp,
                        modifier = Modifier
                            .width(108.dp)
                            .padding(top = 2.dp)
                    )
                }
            }
        }
    } else {
        Text(
            text = stringResource(id = R.string.try_later),
            style = CassbanaTheme.typography.helpText1,
            color = Red1
        )
    }
    Spacer(modifier = Modifier.height(24.dp))
    Button(
        onClick = {
            onConfirmClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = RoyalBlue1,
            disabledContainerColor = Neutral2, disabledContentColor = Neutral5
        ),
        enabled = otp.length == length
    ) {
        Text(
            text = stringResource(id = R.string.confirm),
            style = CassbanaTheme.typography.actionButton
        )
    }

    if (ticks > 0) {
        LaunchedEffect(Unit) {
            while (ticks > 0) {
                delay(1_000)
                ticks--
            }
        }
    }
}