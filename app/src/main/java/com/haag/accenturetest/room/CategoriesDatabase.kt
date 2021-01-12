package com.haag.accenturetest.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.haag.accenturetest.model.Categories

@Database(entities = [Categories::class], version = 1, exportSchema = false)
public abstract class CategoriesDatabase : RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
}