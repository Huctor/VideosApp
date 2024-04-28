package com.example.videosapp.utils

import java.util.Calendar
import java.util.Locale

/**
 * Created by Hu AN on 28/04/2024
 */

// timestamp to date time
object DateTools {
    fun getDate(ts:Long?):String{
        if(ts == null) return ""
        //Get instance of calendar
        val calendar = Calendar.getInstance(Locale.getDefault())
        //get current date from ts
        calendar.timeInMillis = ts
        //return formatted date
        return android.text.format.DateFormat.format("dd MMMM yyyy, HH:mm:ss", calendar).toString()
    }
}