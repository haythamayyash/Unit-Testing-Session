package com.example.unittestingsession.mockitoexample

interface QuestionCache {
    fun cacheQuestion(question: Question)
    fun getQuestion(): Question
}