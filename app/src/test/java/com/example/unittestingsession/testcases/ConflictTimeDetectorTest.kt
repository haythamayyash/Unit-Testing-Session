package com.example.unittestingsession.testcases

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test

class ConflictTimeDetectorTest {
    private lateinit var sut: ConflictTimeDetector

    @Before
    fun setUp() {
        sut = ConflictTimeDetector()
    }

    @Test
    fun hasTimeConflict_time1BeforeTime2_falseReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("9:00", "10:00"),
            timeInterval2 = TimeInterval("12:00", "13:00")
        )
        assertThat(hasTimeConflict, Is.`is`(false))
    }

    @Test
    fun hasTimeConflict_time1AfterTime2_falseReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("12:00", "13:00"),
            timeInterval2 = TimeInterval("9:00", "10:00")
        )
        assertThat(hasTimeConflict, Is.`is`(false))
    }

    @Test
    fun hasTimeConflict_time1OverlapTime2FromStart_trueReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("12:00", "13:00"),
            timeInterval2 = TimeInterval("12:45", "14:00")
        )
        assertThat(hasTimeConflict, Is.`is`(true))
    }

    @Test
    fun hasTimeConflict_time1OverlapTime2FromEnd_trueReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("13:45", "15:00"),
            timeInterval2 = TimeInterval("12:45", "14:00")
        )
        assertThat(hasTimeConflict, Is.`is`(true))
    }

    @Test
    fun hasTimeConflict_time1PartOfTime2_trueReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("13:00", "13:30"),
            timeInterval2 = TimeInterval("12:00", "14:00")
        )
        assertThat(hasTimeConflict, Is.`is`(true))
    }

    @Test
    fun hasTimeConflict_time2PartOfTime1_trueReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("12:00", "14:00"),
            timeInterval2 = TimeInterval("13:00", "13:30")
        )
        assertThat(hasTimeConflict, Is.`is`(true))
    }

    @Test
    fun hasTimeConflict_time1MatchTime2_trueReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("12:00", "14:00"),
            timeInterval2 = TimeInterval("12:00", "14:30")
        )
        assertThat(hasTimeConflict, Is.`is`(true))
    }

    @Test
    fun hasTimeConflict_time1AdjacentTime2FromStart_falseReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("12:00", "14:00"),
            timeInterval2 = TimeInterval("14:00", "14:30")
        )
        assertThat(hasTimeConflict, Is.`is`(false))
    }

    @Test
    fun hasTimeConflict_time1AdjacentTime2FromEnd_falseReturned() {
        val hasTimeConflict = sut.hasTimeConflict(
            timeInterval1 = TimeInterval("14:30", "15:00"),
            timeInterval2 = TimeInterval("14:00", "14:30")
        )
        assertThat(hasTimeConflict, Is.`is`(false))
    }

}