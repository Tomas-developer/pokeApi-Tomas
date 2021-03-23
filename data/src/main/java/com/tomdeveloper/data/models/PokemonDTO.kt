package com.tomdeveloper.data.models

data class PokemonDTO (val name:String,
                       val url:String,
                       var urlImage:String,
                       var id:Int,
                       var height:String?,
                       var weight:Double?,
                       val types:List<Types>?)
