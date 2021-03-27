package com.tomdeveloper.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/tomdeveloper/data/local/PokemonFavouritesDao;", "", "deletePokemonFavourite", "", "pokemonDTO", "Lcom/tomdeveloper/data/models/PokemonDTO;", "getPokemonFavouriteFindId", "id", "", "getPokemonFavourites", "", "savePokemonFavourite", "data_debug"})
public abstract interface PokemonFavouritesDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void savePokemonFavourite(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.PokemonDTO pokemonDTO);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM favourites")
    public abstract java.util.List<com.tomdeveloper.data.models.PokemonDTO> getPokemonFavourites();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM favourites WHERE id =:id")
    public abstract com.tomdeveloper.data.models.PokemonDTO getPokemonFavouriteFindId(int id);
    
    @androidx.room.Delete()
    public abstract void deletePokemonFavourite(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.PokemonDTO pokemonDTO);
}