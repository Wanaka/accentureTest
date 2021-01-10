package com.haag.accenturetest.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNotificationService(): CategoriesAPI {
        return Retrofit.Builder()
            .baseUrl("https://private-anon-851568b03f-androidtestmobgen.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoriesAPI::class.java)
    }
}