package com.example.unittestingsession.testdouble

interface QuestionCache {
    fun cacheQuestion(question: Question)
    fun getQuestion(): Question
}