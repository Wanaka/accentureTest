package com.haag.accenturetest.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {
    
    @Provides
    fun provideChannelDao(appDatabase: CategoriesDatabase): CategoriesDao {
        return appDatabase.categoriesDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): CategoriesDatabase {
        return Room.databaseBuilder(
            appContext,
            CategoriesDatabase::class.java,
            "category_db"
        ).build()
    }
}