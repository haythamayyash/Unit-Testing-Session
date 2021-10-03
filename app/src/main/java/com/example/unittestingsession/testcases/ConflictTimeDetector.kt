package com.example.unittestingsession.testcases

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

class ConflictTimeDetector {
   private val parser = SimpleDateFormat("HH:mm")
    init {
        parser.isLenient = false
    }
    /**
     * time should be in 24 hour system
     */
    @Throws(ParseException::class)
    fun hasTimeConflict(timeInterval1: TimeInterval, timeInterval2: TimeInterval): Boolean {
        return parser.parse(timeInterval1.endTime) > parser.parse(timeInterval2.startTime) &&
                parser.parse(timeInterval1.startTime) < parser.parse(timeInterval2.endTime)
    }
}


data class TimeInterval(val startTime: String, val endTime: String)