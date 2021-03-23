package com.tomdeveloper.pokeapi.home_activity.pokemon.mv

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.remote.ResultHandler
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.pokeapi.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository) : BaseViewModel() {

    private var _pokemonList: MutableLiveData<MutableList<PokemonDTO>> = MutableLiveData<MutableList<PokemonDTO>>()
    val pokemonList get() = _pokemonList

    init {
        showNetworkError.value = false
    }

    fun getPokemon(offset:Int, limit:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when(val result = repository.getObjApiDTO(offset, limit)){
                is ResultHandler.Success-> {
                    /* dado que la carga de los pokemon se hace progresivamente cada vez que el scroll
                    * llega abajo en el recyclerview, aquí lo que hago es comprobar y si la lista
                    * esta nula o vacia, si lo esta meto la lista que me llega del repositorio
                    *  y sino creo una lista a la cual le añado la que me llega para evitar perder los
                    * pokemon que ya tengo cargados :D !   */
                    if(_pokemonList.value.isNullOrEmpty()){
                        _pokemonList.postValue(result.data.results)
                    }else{
                        var pokemons = _pokemonList.value
                        pokemons?.addAll(result.data.results)
                        pokemons?.let {
                            _pokemonList.postValue(it)
                        }
                    }
                }
                is ResultHandler.NetworkError -> {
                    showNetworkError.postValue(true)
                }

                else -> {
                    showNetworkError.postValue(true)
                }
            }
        }
    }

}