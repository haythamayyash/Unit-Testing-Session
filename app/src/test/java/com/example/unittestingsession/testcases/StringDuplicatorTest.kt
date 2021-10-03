package com.example.unittestingsession.testcases

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.junit.Before
import org.junit.Test

class StringDuplicatorTest{

    private lateinit var sut: StringDuplicator

    @Before
    fun setUp() {
        sut = StringDuplicator()
    }

    @Test
    fun duplicateString_emptyString_emptyStringReturned() {
        val text = sut.duplicateString("")
        assertThat(text , Is.`is`(""))
    }

    @Test
    fun duplicateString_oneChar_duplicatedStringReturned() {
        val text = sut.duplicateString("a")
        assertThat(text , Is.`is`("aa"))
    }

    @Test
    fun duplicateString_longString_duplicatedStringReturned() {
        val text = sut.duplicateString("Haitham")
        assertThat(text , Is.`is`("HaithamHaitham"))
    }
}