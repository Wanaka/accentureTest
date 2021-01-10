package com.haag.accenturetest.retrofit

import com.haag.accenturetest.model.Categories
import retrofit2.http.GET

interface CategoriesAPI {

    @GET("categories")
    suspend fun getCategories(): List<Categories>
}