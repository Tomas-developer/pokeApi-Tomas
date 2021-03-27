package com.tomdeveloper.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J5\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tomdeveloper/data/remote/IPokemonApi;", "", "getPokemonFindId", "Lretrofit2/Response;", "Lcom/tomdeveloper/data/models/PokemonDTO;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemons", "Lcom/tomdeveloper/data/models/ObjApiDTO;", "pagination", "offset", "", "limit", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract interface IPokemonApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/{pagination}")
    public abstract java.lang.Object getPokemons(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "pagination")
    java.lang.String pagination, @retrofit2.http.Query(value = "offset")
    int offset, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.tomdeveloper.data.models.ObjApiDTO>> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/pokemon/{id}")
    public abstract java.lang.Object getPokemonFindId(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.tomdeveloper.data.models.PokemonDTO>> p1);
}