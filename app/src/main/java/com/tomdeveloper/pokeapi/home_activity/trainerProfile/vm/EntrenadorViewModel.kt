package com.tomdeveloper.pokeapi.home_activity.trainerProfile.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.models.ProfileDto
import com.tomdeveloper.data.repositories.PokemonRepository
import com.tomdeveloper.data.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntrenadorViewModel(var profileRepository: ProfileRepository, var pokemonRepository: PokemonRepository ) : ViewModel() {

    private var _profile: MutableLiveData<ProfileDto> = MutableLiveData()
    val profile get() = _profile

    private var _pokemonFavourites: MutableLiveData<List<PokemonDTO>> = MutableLiveData()
    val pokemonFavourites get() = _pokemonFavourites

    fun saveProfile(dto: ProfileDto){
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.saveProfile(dto)
        }
    }

    fun loadProfile(){
        viewModelScope.launch(Dispatchers.IO) {
            _profile.postValue(profileRepository.loadProfile())
        }
    }

    fun loadPokemonFavourites(){
        viewModelScope.launch(Dispatchers.IO) {
            pokemonRepository.getAllFavourites().let {
                _pokemonFavourites.postValue(it)
            }
        }
    }

    fun deletePokemonFavourite(){
        
    }
}