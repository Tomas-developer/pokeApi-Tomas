package com.tomdeveloper.data.repositories

import com.tomdeveloper.data.commons.getIdPokemonFromUrlApi
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.remote.IPokemonApi

class PokemonRepository(private val remoteApi: IPokemonApi) {

    suspend fun getPokemon():MutableList<PokemonDTO>{
        var datos: MutableList<PokemonDTO>? = remoteApi.getPokemons().body()?.results?.toMutableList()
        /* Dado que quiero que en el listado ya se muestren imagenes de los pokemon he creado una extension
        * de un string, que me pilla el id del pokemon desde la url, y con ese id formo otra url donde
        * se aloja una imagen del pokemon, es un sprite del juego con lo cual la imagen ocupa muy poquito
        * y me sirve para el adaptador */
        if(!datos.isNullOrEmpty()){
            for (i in 0 until datos.size){
                var pokemon = datos[i]
                val idPokemon = pokemon.url.getIdPokemonFromUrlApi()
                pokemon.urlImage = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/${idPokemon}.png"
                pokemon.id = idPokemon
                datos[i] = pokemon
            }
        }else{
            datos = mutableListOf()
        }
        return datos
    }

    suspend fun getPokemonFindId(id: String): PokemonDTO? {
        return remoteApi.getPokemonFindId(id)?.body()
    }

}