package com.example.ageincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_months.*
import kotlinx.android.synthetic.main.activity_years.*

class Months : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_months)
        val totalMonths = intent.getStringExtra(NAME_EXTRA)
        MonthsText.setText(totalMonths)
    }
}