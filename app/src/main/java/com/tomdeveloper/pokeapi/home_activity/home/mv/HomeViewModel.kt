package com.tomdeveloper.pokeapi.home_activity.home.mv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.pokeapi.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    private var _pokemonList: MutableLiveData<List<PokemonDTO>> = MutableLiveData()
    val pokemonList get() = _pokemonList

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemonList.postValue(repository.getPokemon())
        }
    }
}