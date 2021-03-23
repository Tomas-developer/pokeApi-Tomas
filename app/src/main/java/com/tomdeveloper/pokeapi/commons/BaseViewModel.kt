package com.tomdeveloper.pokeapi.commons

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    var showNetworkError: MutableLiveData<Boolean> = MutableLiveData<Boolean>()

}