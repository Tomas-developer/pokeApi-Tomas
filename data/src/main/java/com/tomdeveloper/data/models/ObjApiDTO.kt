package com.tomdeveloper.data.models
// objeto principal de la api
data class ObjApiDTO (val count:String, val next:String, val previus:String, var results:MutableList<PokemonDTO>)