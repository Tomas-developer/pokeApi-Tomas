package com.tomdeveloper.data.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u000e\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tomdeveloper/data/repositories/PokemonRepository;", "Lcom/tomdeveloper/data/commons/BaseRepository;", "remoteApi", "Lcom/tomdeveloper/data/remote/IPokemonApi;", "favouritesDatabase", "Lcom/tomdeveloper/data/local/PokemonFavouriteDatabase;", "(Lcom/tomdeveloper/data/remote/IPokemonApi;Lcom/tomdeveloper/data/local/PokemonFavouriteDatabase;)V", "deleteFavouritePokemon", "", "pokemon", "Lcom/tomdeveloper/data/models/PokemonDTO;", "getAllFavourites", "", "getFavouriteFindId", "id", "", "getObjApiDTO", "Lcom/tomdeveloper/data/remote/ResultHandler;", "Lcom/tomdeveloper/data/models/ObjApiDTO;", "offset", "limit", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonFindId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFavouritePokemon", "pokemonDTO", "data_debug"})
public final class PokemonRepository extends com.tomdeveloper.data.commons.BaseRepository {
    private final com.tomdeveloper.data.remote.IPokemonApi remoteApi = null;
    private final com.tomdeveloper.data.local.PokemonFavouriteDatabase favouritesDatabase = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getObjApiDTO(int offset, int limit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.tomdeveloper.data.remote.ResultHandler<com.tomdeveloper.data.models.ObjApiDTO>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPokemonFindId(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.tomdeveloper.data.remote.ResultHandler<com.tomdeveloper.data.models.PokemonDTO>> p1) {
        return null;
    }
    
    public final void saveFavouritePokemon(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.PokemonDTO pokemonDTO) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.tomdeveloper.data.models.PokemonDTO getFavouriteFindId(int id) {
        return null;
    }
    
    public final void deleteFavouritePokemon(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.PokemonDTO pokemon) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.tomdeveloper.data.models.PokemonDTO> getAllFavourites() {
        return null;
    }
    
    public PokemonRepository(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.remote.IPokemonApi remoteApi, @org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.local.PokemonFavouriteDatabase favouritesDatabase) {
        super();
    }
}