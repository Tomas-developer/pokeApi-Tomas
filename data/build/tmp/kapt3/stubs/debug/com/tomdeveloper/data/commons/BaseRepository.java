package com.tomdeveloper.data.commons;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\b0\u0007H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tomdeveloper/data/commons/BaseRepository;", "", "()V", "safeApiCall", "Lcom/tomdeveloper/data/remote/ResultHandler;", "T", "call", "Lkotlin/Function0;", "Lretrofit2/Response;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public abstract class BaseRepository {
    
    @org.jetbrains.annotations.Nullable()
    public final <T extends java.lang.Object>java.lang.Object safeApiCall(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<retrofit2.Response<T>> call, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.tomdeveloper.data.remote.ResultHandler<? extends T>> p1) {
        return null;
    }
    
    public BaseRepository() {
        super();
    }
}