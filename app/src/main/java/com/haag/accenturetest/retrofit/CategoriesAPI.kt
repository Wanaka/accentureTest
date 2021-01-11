package com.haag.accenturetest.retrofit

import com.haag.accenturetest.model.Book
import com.haag.accenturetest.model.Categories
import com.haag.accenturetest.model.Character
import com.haag.accenturetest.model.House
import retrofit2.http.GET

interface CategoriesAPI {

    @GET("categories")
    suspend fun getCategories(): List<Categories>

    @GET("list/1")
    suspend fun getBooks(): List<Book>

    @GET("list/2")
    suspend fun getHouses(): List<House>

    @GET("list/3")
    suspend fun getCharacters(): List<Character>

}