package com.ev.myapplication.core.network

import com.ev.myapplication.model.respose.CategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("categories")
    suspend fun getCategories() : List<String>

    @GET("random")
    suspend fun getCategoryDetails(@Query("category") category: String) : CategoriesResponse
}