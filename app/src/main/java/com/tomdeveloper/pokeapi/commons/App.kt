package com.tomdeveloper.pokeapi.commons

import android.app.Application
import android.util.Log
import com.tomdeveloper.data.di.dataModule
import com.tomdeveloper.pokeapi.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.w("infoapp", "Iniciando applicación")
        startKoin {
            androidContext(this@App)
            modules(listOf(uiModule, dataModule))
        }
    }
}