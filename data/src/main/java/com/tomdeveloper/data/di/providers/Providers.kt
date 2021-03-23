package com.tomdeveloper.data.di.providers

import android.app.Application
import android.content.Context
import android.widget.SimpleCursorAdapter
import androidx.room.RoomDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.local.ProfileDatabase
import com.tomdeveloper.data.remote.IPokemonApi
import com.tomdeveloper.data.repositories.ProfileRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


fun providePokemonApi(retrofit: Retrofit) : IPokemonApi = retrofit
    .create(IPokemonApi::class.java)

fun provideRetrofit(gson: Gson): Retrofit = Retrofit
    .Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(Constants.REMOTE_API_BASE_URL)
    .build()

fun provideGson(): Gson {
    return GsonBuilder()
            .setLenient()
            .serializeNulls()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .create()
}

fun provideProfileDatabase(application: Application): ProfileDatabase {
    return ProfileDatabase.getInstance(application)
}