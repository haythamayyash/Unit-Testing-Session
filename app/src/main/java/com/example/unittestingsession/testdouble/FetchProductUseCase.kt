package com.example.unittestingsession.testdouble


class FetchProductUseCase(
    private val productService: ProductService,
    private val productCache: ProductCache,
    private val productAnalyticManager: ProductAnalyticManager
) {

    sealed class Result {
        data class Success(val product: Product) : Result()
        object Failure : Result()
        object NetworkError : Result()

    }

    fun getProduct(id: String): Result {
        try {
            val serviceResult: ProductService.ServiceResult = productService.getProduct(id)
            return when (serviceResult) {
                is ProductService.ServiceResult.Success -> {
                    val product = serviceResult.product
                    productCache.cacheProduct(product)
                    Result.Success(product)
                }
                is ProductService.ServiceResult.GeneralError -> {
                    productAnalyticManager.logFailure()
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