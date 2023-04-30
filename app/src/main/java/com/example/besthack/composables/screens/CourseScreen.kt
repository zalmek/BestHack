package com.example.besthack.composables.screens

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.besthack.R
import com.example.besthack.ui.theme.models.PetrolCityCourse
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun CourseScreen(
    modifier: Modifier = Modifier,
    courses: PetrolCityCourse
) {
    //2202.03.30
    fun reverse(date: String): String {
        return date.slice(8..9) + "." + date.slice(5..6) + "." + date.slice(0..3)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        var showPicker1 by remember { mutableStateOf(false) }
        var showPicker2 by remember { mutableStateOf(false) }
        var beginDate by remember {
            mutableStateOf(
                reverse(
                    LocalDate.now().minusMonths(6).format(DateTimeFormatter.ISO_LOCAL_DATE)
                        .toString().replace('-', '.')
                )
            )
        }
        var endDate by remember {
            mutableStateOf(
                reverse(
                    LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).toString()
                        .replace('-', '.')
                )
            )
        }

        TopAppBar(
            modifier = Modifier.fillMaxHeight(0.1f),
            backgroundColor = (Color(android.graphics.Color.parseColor("#2688EB"))),
            elevation = 10.dp
        ) {
            Text(text = courses.city + " - период: ", color = Color.White)
            Column() {
                Text(modifier = Modifier.padding(15.dp),text = beginDate, color = Color.White)
                Button(modifier = Modifier.padding(end = 10.dp).align(CenterHorizontally),onClick = {showPicker1=true}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(android.graphics.Color.parseColor("#2688EB")))) {
                    Image(imageVector = ImageVector.vectorResource(R.drawable.baseline_edit_calendar_24), contentDescription = "Change begin date")
                }
            }

            Column() {
                Text(modifier = Modifier.padding(15.dp),text = " - ", color = Color.White)
            }


            Column() {
                Text(modifier = Modifier.padding(15.dp),text = endDate, color = Color.White)
                Button(modifier = Modifier.align(CenterHorizontally), onClick = {showPicker2=true}, colors = ButtonDefaults.buttonColors(backgroundColor = Color(android.graphics.Color.parseColor("#2688EB")))) {
                    Image(imageVector = ImageVector.vectorResource(R.drawable.baseline_edit_calendar_24), contentDescription = "Change begin date")                }
            }

            val mContext = LocalContext.current

            // Declaring integer values
            // for year, month and day
            val mYear: Int
            val mMonth: Int
            val mDay: Int

            // Initializing a Calendar
            val mCalendar = Calendar.getInstance()

            // Fetching current year, month and day
            mYear = mCalendar.get(Calendar.YEAR)
            mMonth = mCalendar.get(Calendar.MONTH)
            mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

            mCalendar.time = Date()

            // Declaring a string value to
            // store date in string format


            // Declaring DatePickerDialog and setting
            // initial values as current values (present year, month and day)
            val mDatePickerDialog = DatePickerDialog(
                mContext,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    beginDate = "$mDayOfMonth/${mMonth + 1}/$mYear"
                }, mYear, mMonth, mDay
            )
            if (showPicker1) {
                mDatePickerDialog.datePicker.maxDate = System.currentTimeMillis()
                mDatePickerDialog.datePicker.minDate = System.currentTimeMillis()-1000L*60*60*24*365*10
                mDatePickerDialog.show()
            }
            val mDatePickerDialog2 = DatePickerDialog(
                mContext,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    endDate = "$mDayOfMonth/${mMonth + 1}/$mYear"
                }, mYear, mMonth, mDay
            )
            if (showPicker2) {
                mDatePickerDialog2.datePicker.maxDate = System.currentTimeMillis()
                mDatePickerDialog2.datePicker.minDate = System.currentTimeMillis()-1000L*60*60*24*365*10
                mDatePickerDialog2.show()
            }
            showPicker1 = false
            showPicker2 = false
        }
    }

}