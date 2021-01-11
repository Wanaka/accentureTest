package com.haag.accenturetest.repository

import com.haag.accenturetest.retrofit.CategoriesAPI
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoriesApi: CategoriesAPI) {

    suspend fun getBooks() = categoriesApi.getBooks()

    suspend fun getHouses() = categoriesApi.getHouses()

    suspend fun getCharacters() = categoriesApi.getCharacters()
}