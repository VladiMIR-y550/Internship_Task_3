package com.mironenko.internship_task_3.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@SuppressLint("SimpleDateFormat")
class UserDateFormatter @Inject constructor() : DateFormatter {
    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private val outputFormat = SimpleDateFormat("d MMMM yyyy H:mm")

    override fun stringDateFormat(dateString: String): String {
        return formatDateToString(parseStringToDate(dateString))
    }

    private fun parseStringToDate(dateString: String): Date {
        return inputFormat.parse(dateString) as Date
    }

    private fun formatDateToString(date: Date): String {
        return outputFormat.format(date)
    }
}