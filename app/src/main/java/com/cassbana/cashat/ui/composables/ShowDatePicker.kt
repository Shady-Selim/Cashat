package com.cassbana.cashat.ui.composables

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.cassbana.cashat.R
import com.cassbana.cashat.ui.theme.CassbanaTheme
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDatePicker(datePicked: String, updatedDate: (String?) -> Unit) {
    val mContext = LocalContext.current
    OutlinedTextField(
        value = datePicked,
        onValueChange = {},
        label = {
            Text(
                stringResource(id = R.string.dob),
                style = CassbanaTheme.typography.paragraph2
            )
        },
        readOnly = true,
        enabled = false,
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_calendar), "")
        },
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { showDatePicker(mContext as AppCompatActivity, updatedDate) }),
        textStyle = CassbanaTheme.typography.paragraph2//TextStyle( color = Neutral8)
    )
}

private fun showDatePicker(
    activity: AppCompatActivity,
    updatedDate: (String?) -> Unit
) {
    val picker = MaterialDatePicker.Builder.datePicker().build()
    picker.show(activity.supportFragmentManager, picker.toString())
    picker.addOnPositiveButtonClickListener {
        updatedDate(DateFormater(it.toLong()))
    }
}

private fun DateFormater(milliseconds: Long?): String? {
    return milliseconds?.let {
        val formatter = SimpleDateFormat("dd MMMM yyyy", Locale("ar"))
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTimeInMillis(it)
        formatter.format(calendar.getTime())
    }
}