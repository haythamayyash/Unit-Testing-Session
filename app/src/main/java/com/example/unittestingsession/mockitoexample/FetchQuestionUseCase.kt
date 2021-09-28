package com.example.unittestingsession.mockitoexample


class FetchQuestionUseCase(
    private val questionService: QuestionService,
    private val questionCache: QuestionCache
) {

    sealed class Result {
        data class Success(val question: Question) : Result()
        object Failure : Result()
        object NetworkError : Result()

    }

    fun getQuestion(id: String): Result {
        try {
            val serviceResult: QuestionService.ServiceResult = questionService.getQuestion(id)
            return when (serviceResult) {
                is QuestionService.ServiceResult.Success -> {
                    val question = serviceResult.question
                    questionCache.cacheQuestion(question)
                    Result.Success(question)
                }
                is QuestionService.ServiceResult.GeneralError -> {
                    Result.NetworkError
                }
                else -> {
                    Result.Failure
                }
            }
        } catch (exception: NetworkErrorException) {
            return Result.NetworkError
        }
    }


}