package com.tomdeveloper.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.models.converters.Converters


@Database(entities = [PokemonDTO::class], version = 1)
@TypeConverters(value = [Converters::class])
abstract class PokemonFavouriteDatabase: RoomDatabase() {

    abstract fun pokemonFavouriteDao(): PokemonFavouritesDao

    companion object{
        @Volatile
        private var INSTANCE: PokemonFavouriteDatabase?= null

        fun getInstance(context: Context): PokemonFavouriteDatabase =
                INSTANCE ?: synchronized(this){
                    INSTANCE
                            ?: buildDatabase(context.applicationContext).also {
                               INSTANCE = it
                    }
                }

        private fun buildDatabase(appContext: Context): PokemonFavouriteDatabase{
            return Room.databaseBuilder(appContext, PokemonFavouriteDatabase::class.java, Constants.TABLE_POKEMONS_FAVOURITES)
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

}

