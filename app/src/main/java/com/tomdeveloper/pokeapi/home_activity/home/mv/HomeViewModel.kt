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

    private lateinit var pokemon:List<PokemonDTO>
    var pokemonList: MutableLiveData<List<PokemonDTO>> = MutableLiveData()

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
           // pokemon = repository.getPokemon()
            pokemonList.postValue(repository.getPokemon())
        }

    }
}