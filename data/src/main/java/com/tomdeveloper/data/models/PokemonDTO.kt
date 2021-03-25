package com.tomdeveloper.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomdeveloper.data.commons.Constants

@Entity(tableName = Constants.TABLE_POKEMONS_FAVOURITES)
data class PokemonDTO (@PrimaryKey val name:String,
                       val url:String,
                       var urlImage:String,
                       var id:Int,
                       var height:String?,
                       var weight:Double?,
                       val types:List<Types>?,
                       var favourite:Boolean)
