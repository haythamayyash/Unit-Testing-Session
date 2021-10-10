package com.example.unittestingsession.testdouble

interface ProductCache {
    fun cacheProduct(product: Product)
    fun getProduct(): Product
}