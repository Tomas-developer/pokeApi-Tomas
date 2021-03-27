package com.tomdeveloper.data.repositories

import com.tomdeveloper.data.commons.BaseRepository
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.commons.getIdPokemonFromUrlApi
import com.tomdeveloper.data.local.PokemonFavouriteDatabase
import com.tomdeveloper.data.models.ObjApiDTO
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.remote.IPokemonApi
import com.tomdeveloper.data.remote.ResultHandler

class PokemonRepository(private val remoteApi: IPokemonApi, private val favouritesDatabase: PokemonFavouriteDatabase) :BaseRepository(){

    /**************** API REMOTA **********************/

    suspend fun getObjApiDTO(offset:Int, limit:Int): ResultHandler<ObjApiDTO> {
        return when (val result = safeApiCall(call = { remoteApi.getPokemons("pokemon",offset, limit) })) {
            is ResultHandler.Success -> {
                for (i in 0 until result.data.results.size){
                    //de la url obtengo el id del pokemon
                    var id:Int? = result.data.results[i].url?.getIdPokemonFromUrlApi()?.toInt()
                    var pokemon = result.data.results[i]
                    if (id != null) {
                        pokemon.id = id
                    }
                    pokemon.urlImage = Constants.URL_IMG_SPRITE+"$id.png"
                    result.data.results[i] = pokemon
                }
                result
            }
            is ResultHandler.GenericError -> result
            is ResultHandler.HttpError -> result
            is ResultHandler.NetworkError -> result
        }
    }

    suspend fun getPokemonFindId(id: String): ResultHandler<PokemonDTO> {
        return when (val result = safeApiCall(call = { remoteApi.getPokemonFindId(id) })) {
            is ResultHandler.Success -> {
                var pokemon = result.data
                pokemon?.weight = pokemon?.weight?.div(10)
                pokemon.urlImage = Constants.URL_IMG_SPRITE+pokemon.id
                // si el pokemon existe en la bd local, al obtenerlo le pongo un true para marcar como favorito
                if(getFavouriteFindId(pokemon.id) != null){
                    pokemon.favourite = true
                }
                result
            }
            is ResultHandler.GenericError -> result
            is ResultHandler.HttpError -> result
            is ResultHandler.NetworkError -> result
        }
    }

    /**************** BASE DE DATOS LOCAL **********************/

   fun saveFavouritePokemon(pokemonDTO: PokemonDTO){
        favouritesDatabase.pokemonFavouriteDao().savePokemonFavourite(pokemonDTO)
   }

    fun getFavouriteFindId(id: Int): PokemonDTO? {
        return favouritesDatabase.pokemonFavouriteDao().getPokemonFavouriteFindId(id)
    }

    fun deleteFavouritePokemon(pokemon: PokemonDTO){
        favouritesDatabase.pokemonFavouriteDao().deletePokemonFavourite(pokemon)
    }

    fun getAllFavourites():List<PokemonDTO>{
        return favouritesDatabase.pokemonFavouriteDao().getPokemonFavourites()
    }
}