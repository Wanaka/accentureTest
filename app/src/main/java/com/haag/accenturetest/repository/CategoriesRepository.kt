package com.haag.accenturetest.repository

import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.retrofit.CategoriesAPI
import com.haag.accenturetest.room.CategoriesDao
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val categoriesApi: CategoriesAPI,
    private val categoriesDao: CategoriesDao
) {
    suspend fun getCategoriesApi() = categoriesApi.getCategories()

    suspend fun saveCategories(categories: Categories) = categoriesDao.insertAll(categories)

    suspend fun getCategories() = categoriesDao.getAll()

}