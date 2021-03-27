package com.tomdeveloper.data.remote

import com.tomdeveloper.data.models.ObjApiDTO
import com.tomdeveloper.data.models.PokemonDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokemonApi {
    @GET("v2/{pagination}")
    suspend fun getPokemons(@Path ("pagination") pagination: String , @Query("offset") offset: Int, @Query("limit") limit: Int): Response<ObjApiDTO>

    @GET("v2/pokemon/{id}")
    suspend fun getPokemonFindId(@Path("id") id:String): Response<PokemonDTO>
}