package com.tomdeveloper.pokeapi.home_activity.entrenador.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tomdeveloper.data.models.ProfileDto
import com.tomdeveloper.data.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntrenadorViewModel(var profileRepository: ProfileRepository ) : ViewModel() {

    private var _profile: MutableLiveData<ProfileDto> = MutableLiveData()
    val profile get() = _profile

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
}