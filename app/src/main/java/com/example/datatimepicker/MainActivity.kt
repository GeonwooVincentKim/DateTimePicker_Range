package com.example.datatimepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    private val clickButton: Button by lazy {
        findViewById(R.id.clickButton)
    }

    private val showDateResult: TextView by lazy {
        findViewById(R.id.showDateResult)
    }

    private var day: Int = 0

    private var week: Int = 0
    private var month: Int = 0
    private var year: Int = 0

    private var hour: Int = 0
    private var minute: Int = 0

    private var savedDay: Int = 0

    private var savedMonth: Int = 0
    private var savedWeek: Int = 0
    private var savedYear: Int = 0

    private var savedHour: Int = 0
    private var savedMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickDate()
    }

    private fun getDateTimeCalendar() {
        val cal = Calendar.getInstance()

        day = cal.get(Calendar.DAY_OF_MONTH)
        week = cal.get(Calendar.DAY_OF_WEEK)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)

        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        clickButton.setOnClickListener {
            getDateTimeCalendar()

            DatePickerDialog(this, this, year, month, day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        showDateResult.text = "$savedDay - $savedMonth - $savedYear\nHour : $savedHour\nMinute : $savedMinute"
    }
}