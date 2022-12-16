package com.cassbana.cashat.ui.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cassbana.cashat.R
import com.cassbana.cashat.helper.LtrRtlDarkLightPreviews
import com.cassbana.cashat.ui.composables.ShowDatePicker
import com.cassbana.cashat.ui.theme.*

@Composable
fun GetIntroduced(mobile: String = "011", onConfirmClick: () -> Unit = {}) {
    val genderOptions =
        listOf(stringResource(id = R.string.male), stringResource(id = R.string.female))
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(genderOptions[0]) }

    Column {
        /*val mDate = remember { mutableStateOf("") }

        val mCalendar = Calendar.getInstance()
        val mYear = mCalendar.get(Calendar.YEAR)
        val mMonth = mCalendar.get(Calendar.MONTH)
        val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
        mCalendar.time = Date()

        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYear, mMonth, mDay
        )*/
        var datePicked: String? by remember {
            mutableStateOf(null)
        }
        val updatedDate = { date: String? ->
            datePicked = date ?: ""
        }

        Text(
            text = stringResource(id = R.string.introduce_yourself),
            style = CassbanaTheme.typography.titleSecondary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.we_need_your_info),
            style = CassbanaTheme.typography.paragraph2,
            color = Neutral6
        )
        Spacer(modifier = Modifier.height(24.dp))
        ShowDatePicker(datePicked ?: "", updatedDate)
        Spacer(modifier = Modifier.height(49.dp))
        Text(
            text = stringResource(id = R.string.gender),
            style = CassbanaTheme.typography.paragraph2,
            color = Neutral6
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            genderOptions.forEach { text ->
                Row(modifier = Modifier
                    .weight(1f)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) }
                    )
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        colors = RadioButtonDefaults.colors(selectedColor = RoyalBlue1)
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(top = 13.dp),
                        style = CassbanaTheme.typography.helpText1
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(33.dp))
        Button(
            onClick = { onConfirmClick() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = RoyalBlue1,
                disabledContainerColor = Neutral2, disabledContentColor = Neutral5
            )
        ) {
            Text(
                text = stringResource(id = R.string.start_saving),
                style = CassbanaTheme.typography.actionButton
            )
        }
    }
}

@LtrRtlDarkLightPreviews
@Composable
private fun DefaultPreview() {
    CassbanaTheme {
        GetIntroduced()
    }
}