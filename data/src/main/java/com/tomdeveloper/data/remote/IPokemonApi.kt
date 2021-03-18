package com.tomdeveloper.data.remote

import com.tomdeveloper.data.models.ObjApiDTO
import com.tomdeveloper.data.models.PokemonDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemonApi {
    @GET("v2/pokemon?offset=0&limit=1222")
    suspend fun getPokemons(): Response<ObjApiDTO>

    @GET("v2/pokemon/{id}")
    suspend fun getPokemonFindId(@Path("id") id:String): Response<PokemonDTO>
}