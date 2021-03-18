package com.tomdeveloper.data.commons

fun String.getIdPokemonFromUrlApi():String {
    return substring(34, this.length-1)
}