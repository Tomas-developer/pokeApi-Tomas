package com.tomdeveloper.pokeapi.di

import com.tomdeveloper.pokeapi.home_activity.details.vm.DetailsViewModel
import com.tomdeveloper.pokeapi.home_activity.pokemon.mv.PokemonViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var uiModule = module {
    viewModel { PokemonViewModel( get() ) }
    viewModel { SharedPokemonVm() }
    viewModel { DetailsViewModel( get() ) }
}