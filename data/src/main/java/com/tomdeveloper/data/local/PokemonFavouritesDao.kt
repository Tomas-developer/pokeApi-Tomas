package com.tomdeveloper.data.local

import androidx.room.*
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.models.PokemonDTO

@Dao
interface PokemonFavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePokemonFavourite(pokemonDTO: PokemonDTO)

    @Query("SELECT * FROM ${Constants.TABLE_POKEMONS_FAVOURITES}")
    fun getPokemonFavourites(): List<PokemonDTO>

    @Query("SELECT * FROM ${Constants.TABLE_POKEMONS_FAVOURITES} WHERE id =:id" )
    fun getPokemonFavouriteFindId(id: Int): PokemonDTO?

    @Delete
    fun deletePokemonFavourite(pokemonDTO: PokemonDTO)
}