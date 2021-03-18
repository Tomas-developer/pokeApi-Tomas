package com.tomdeveloper.pokeapi.home_activity.details.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.pokeapi.commons.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: PokemonRepository):BaseViewModel() {

    private var _Pokemon: MutableLiveData<PokemonDTO> = MutableLiveData()
    val pokemon get() = _Pokemon

    fun getPokemonFindId(id:String){
        viewModelScope.launch (Dispatchers.IO){
            pokemon.postValue(repository.getPokemonFindId(id))
        }
    }
}