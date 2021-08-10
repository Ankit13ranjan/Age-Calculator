package com.example.ageincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_minutes.*
import kotlinx.android.synthetic.main.activity_seconds.*

class Seconds : AppCompatActivity() {
    companion object{
        const val NAME_EXTRA = "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconds)

        val totalSeconds = intent.getStringExtra(NAME_EXTRA)
        SecondsText.setText(totalSeconds)

    }
}