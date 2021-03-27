package com.tomdeveloper.data.commons

// obtiene el id del pokemon a partir de la url
fun String.getIdPokemonFromUrlApi():String {
    return substring(34, this.length-1)
}