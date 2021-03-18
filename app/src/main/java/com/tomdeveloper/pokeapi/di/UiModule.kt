package com.tomdeveloper.pokeapi.di

import com.tomdeveloper.pokeapi.home_activity.details.ui.DetailsFragment
import com.tomdeveloper.pokeapi.home_activity.details.vm.DetailsViewModel
import com.tomdeveloper.pokeapi.home_activity.home.mv.HomeViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var uiModule = module {
    viewModel { HomeViewModel( get() ) }
    viewModel { SharedPokemonVm() }
    viewModel { DetailsViewModel( get() ) }
}