package com.tomdeveloper.data.di.providers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006\u000e"}, d2 = {"provideFavouritesDatabase", "Lcom/tomdeveloper/data/local/PokemonFavouriteDatabase;", "application", "Landroid/app/Application;", "provideGson", "Lcom/google/gson/Gson;", "providePokemonApi", "Lcom/tomdeveloper/data/remote/IPokemonApi;", "retrofit", "Lretrofit2/Retrofit;", "provideProfileDatabase", "Lcom/tomdeveloper/data/local/ProfileDatabase;", "provideRetrofit", "gson", "data_debug"})
public final class ProvidersKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final com.tomdeveloper.data.remote.IPokemonApi providePokemonApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.tomdeveloper.data.local.ProfileDatabase provideProfileDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.tomdeveloper.data.local.PokemonFavouriteDatabase provideFavouritesDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
}