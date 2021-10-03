package com.example.unittestingsession.introduction

import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.*
import org.hamcrest.core.Is
import org.hamcrest.core.Is.*
import org.junit.Before
import org.junit.Test

class CalculatorTest{
    lateinit var sut : Calculator
    @Before
    fun setUp() {
        sut = Calculator()
    }

    @Test
    fun testAdd() {
        val result = sut.add(3, 4)
        assertThat(result, `is`(7))
    }
}