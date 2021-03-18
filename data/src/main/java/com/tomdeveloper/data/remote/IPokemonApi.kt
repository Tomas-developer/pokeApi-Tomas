package com.tomdeveloper.data.remote

import com.tomdeveloper.data.models.ObjApiDTO
import retrofit2.Response
import retrofit2.http.GET

interface IPokemonApi {
    @GET("v2/pokemon?offset=0&limit=1222")
    suspend fun getPokemons(): Response<ObjApiDTO>
}