package com.example.unittestingsession.mockitoexample


interface QuestionService {

    sealed class ServiceResult {
        data class Success(val question: Question) : ServiceResult()
        object GeneralError : ServiceResult()
        object ServerError : ServiceResult()
    }

    @Throws(Exception::class)
    fun getQuestion(id: String): ServiceResult
}
