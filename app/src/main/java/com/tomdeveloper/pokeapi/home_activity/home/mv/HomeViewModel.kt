package com.tomdeveloper.pokeapi.home_activity.home.mv

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.remote.ResultHandler
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.pokeapi.commons.BaseViewModel
import com.tomdeveloper.pokeapi.commons.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    private var _pokemonList: MutableLiveData<List<PokemonDTO>> = MutableLiveData<List<PokemonDTO>>()
    val pokemonList get() = _pokemonList

    fun getPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = repository.getObjApiDTO()){
                is ResultHandler.Success-> {
                    _pokemonList.postValue(result.data.results)
                }
                else -> {
                    Log.e("error", "error en la red .... ")
                }
            }
        }
    }
}