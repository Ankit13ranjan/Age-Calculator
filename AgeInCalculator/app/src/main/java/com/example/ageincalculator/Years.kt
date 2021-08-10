package com.example.ageincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_days.*
import kotlinx.android.synthetic.main.activity_years.*

class Years : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_years)
        val totalYears = intent.getStringExtra(NAME_EXTRA)
        YearsText.setText(totalYears)
    }
}