package com.tomdeveloper.pokeapi.utils
import androidx.lifecycle.MutableLiveData
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.commons.BaseViewModel

class SharedPokemonVm: BaseViewModel() {

    private var _pokemon: MutableLiveData<PokemonDTO> = MutableLiveData()
    val pokemon get():MutableLiveData<PokemonDTO> = _pokemon

    fun setPokemon(pokemonDTO: PokemonDTO) {
        _pokemon.value = pokemonDTO
    }
}