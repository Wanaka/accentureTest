package com.haag.accenturetest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.haag.accenturetest.model.Categories

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM categories_table")
    suspend fun getAll(): List<Categories>

    @Insert
   suspend fun insertAll(vararg categories: Categories)

}