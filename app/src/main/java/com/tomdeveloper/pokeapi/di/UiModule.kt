package com.tomdeveloper.pokeapi.di

import com.tomdeveloper.pokeapi.home_activity.home.mv.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var uiModule = module {
    viewModel { HomeViewModel( get() ) }
}