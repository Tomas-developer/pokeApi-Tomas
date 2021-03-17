package com.tomdeveloper.pokeapi.commons

import android.app.Application
import android.util.Log
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.w("infoapp", "Iniciando applicación")
        startKoin {

        }
    }
}