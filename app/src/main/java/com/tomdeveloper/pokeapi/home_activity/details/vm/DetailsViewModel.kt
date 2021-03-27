package com.tomdeveloper.pokeapi.home_activity.details.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.remote.ResultHandler
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.pokeapi.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: PokemonRepository):BaseViewModel() {

    private var _pokemon: MutableLiveData<PokemonDTO> = MutableLiveData()
    val pokemon get() = _pokemon


    fun getPokemonFindId(id:String){
        viewModelScope.launch (Dispatchers.IO){
            when(val result = repository.getPokemonFindId(id)){
                is ResultHandler.Success -> {
                    _pokemon.postValue(result.data)
                }
                else -> {
                    showNetworkError.postValue(true)
                }
            }
        }
    }

    fun saveFavouritePokemonToLocalDatabase(){
        viewModelScope.launch(Dispatchers.IO) {
            _pokemon.value?.let {
                repository.saveFavouritePokemon(it)
                Log.e("num", repository.getAllFavourites()?.size.toString() + " ")
            }
        }
    }

    fun deleteFavouritePokemonToLocalDatabase(){
        viewModelScope.launch(Dispatchers.IO) {
            _pokemon.value?.let {
                repository.deleteFavouritePokemon(it)
                Log.e("num", repository.getAllFavourites()?.size.toString() + " ")
            }
        }
    }
}