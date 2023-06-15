package com.kotlin.learn.myapplication.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Helper {

    private const val timestampFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    private const val simpleDateFormat = "dd MMM yyyy HH.mm"

    private var defaultDate = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())

    @SuppressLint("ConstantLocale")
    val simpleDate = SimpleDateFormat(simpleDateFormat, Locale.getDefault())


    private fun getCurrentDate(): Date {
        return Date()
    }

    fun getCurrentDateString(): String = defaultDate.format(getCurrentDate())

    @SuppressLint("ConstantLocale")
    val currentTimestamp: String = SimpleDateFormat(
        "ddMMyySSSSS",
        Locale.getDefault()
    ).format(System.currentTimeMillis())

    // string simpleDate (unformatted) to date
    private fun parseSimpleDate(dateValue: String): Date {
        return defaultDate.parse(dateValue) as Date
    }

    // simpleDate (Date) to string
    private fun getSimpleDate(date: Date): String = simpleDate.format(date)

    // string to string
    fun getSimpleDateString(dateValue: String): String = getSimpleDate(parseSimpleDate(dateValue))


    // string UTC format to date
    private fun parseUTCDate(timestamp: String): Date {
        return try {
            val formatter = SimpleDateFormat(timestampFormat, Locale.getDefault())
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            formatter.parse(timestamp) as Date
        } catch (e: ParseException) {
            getCurrentDate()
        }
    }

}