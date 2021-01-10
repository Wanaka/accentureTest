package com.haag.accenturetest.repository

import com.haag.accenturetest.retrofit.CategoriesAPI
import javax.inject.Inject

class CategoriesRepository @Inject constructor(private val categoriesApi: CategoriesAPI) {

    suspend fun getCategoriesApi() = categoriesApi.getCategories()
}