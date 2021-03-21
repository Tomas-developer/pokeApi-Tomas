package com.tomdeveloper.data.models

data class ObjApiDTO (val count:String, val next:String, val previus:String, var results:MutableList<PokemonDTO>)