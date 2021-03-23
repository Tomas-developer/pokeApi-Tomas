package com.tomdeveloper.data.di

import android.provider.ContactsContract
import com.tomdeveloper.data.di.providers.provideGson
import com.tomdeveloper.data.di.providers.providePokemonApi
import com.tomdeveloper.data.di.providers.provideProfileDatabase
import com.tomdeveloper.data.di.providers.provideRetrofit
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.data.repositories.ProfileRepository
import org.koin.dsl.module

val dataModule = module {
    single { providePokemonApi( get() ) }
    single { provideRetrofit( get() ) }
    single { PokemonRepository( get() ) }
    single { provideGson() }
    single { provideProfileDatabase( get() ) }
    single { ProfileRepository( get() ) }
}