package com.example.ageincalculator

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { view->
            clickDatePicker(view)
        }
    }
    var differenceDateInMinutes =""
    var diffDateInSeconds = ""
    var diffDateInHours = ""
    var diffDateInDays = ""
    var diffDateInYears = ""
    var diffDateInMonths = ""

    fun clickDatePicker(view : View)
    {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        val dpd =DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{
                    view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this,"Date Choosen", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear";

                dateDisplay.setText(selectedDate)


                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate!!.time / 60000


                differenceDateInMinutes= (currentDateInMinutes - selectedDateInMinutes).toString()

                val selectedtDateInSeconds = theDate!!.time / 1000

                val currentDateInSeconds = currentDate!!.time / 1000


                diffDateInSeconds=(currentDateInSeconds - selectedtDateInSeconds).toString()


                val selectedtDateInHours = theDate!!.time / 3600000

                val currentDateInHours = currentDate!!.time / 3600000

                diffDateInHours = (currentDateInHours - selectedtDateInHours).toString()

                val selectedtDateInDays = theDate!!.time / 86400000

                val currentDateInDays = currentDate!!.time / 86400000

                diffDateInDays = (currentDateInDays - selectedtDateInDays).toString()

                val selectedtDateInYears = theDate!!.time /  31104000000

                val currentDateInYears = currentDate!!.time / 31104000000

                diffDateInYears = (currentDateInYears - selectedtDateInYears).toString()

                val selectedtDateInMonths= theDate!!.time /  2592000000

                val currentDateInMonths = currentDate!!.time / 2592000000

                diffDateInMonths = (currentDateInMonths - selectedtDateInMonths-1).toString()

                // Extra -1 is here...because,Months Starts from 0 and we were counting it from 1.
                // For Displaying Date
                // So,here count it from 0 ... for getting Ranges Between Months



            }
            ,year
            ,month
            ,day)

        dpd.datePicker.setMaxDate(Date().time-86400000)
        dpd.show()

    }

    fun createDays(view: View)
    {
        val intent = Intent(this, Days::class.java)
        intent.putExtra(Days.NAME_EXTRA,diffDateInDays)
        startActivity(intent)
    }

    fun createMinutes(view: View)
    {
        val intent = Intent(this, Minutes::class.java)
        intent.putExtra(Minutes.NAME_EXTRA,differenceDateInMinutes)
        startActivity(intent)
    }

    fun creteSeconds(view: View) {
        val intent = Intent(this, Seconds::class.java)
        intent.putExtra(Seconds.NAME_EXTRA, diffDateInSeconds)
        startActivity(intent)
    }

    fun createHours(view: View)
    {
        val intent = Intent(this, Hours::class.java)
        intent.putExtra(Hours.NAME_EXTRA,diffDateInHours)
        startActivity(intent)
    }

    fun createYears(view: View)
    {
        val intent = Intent(this, Years::class.java)
        intent.putExtra(Years.NAME_EXTRA,diffDateInYears)
        startActivity(intent)
    }

    fun createMonths(view: View)
    {
        val intent = Intent(this, Months::class.java)
        intent.putExtra(Months.NAME_EXTRA,diffDateInMonths)
        startActivity(intent)
    }
}