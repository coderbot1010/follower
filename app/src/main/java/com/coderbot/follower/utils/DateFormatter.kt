package com.coderbot.follower.utils

import java.util.*

object DateFormatter
{
    private val days = arrayOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    private val months = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")

    fun format(date: Long): String
    {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = date
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1] + ",  " + calendar.get(Calendar.DAY_OF_MONTH) + " " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR)
    }
}