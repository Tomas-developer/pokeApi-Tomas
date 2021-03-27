package com.tomdeveloper.data.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tomdeveloper/data/repositories/ProfileRepository;", "", "profileDataBase", "Lcom/tomdeveloper/data/local/ProfileDatabase;", "(Lcom/tomdeveloper/data/local/ProfileDatabase;)V", "getProfileDataBase", "()Lcom/tomdeveloper/data/local/ProfileDatabase;", "deleteAll", "", "loadProfile", "Lcom/tomdeveloper/data/models/ProfileDto;", "saveProfile", "profileDto", "data_debug"})
public final class ProfileRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.tomdeveloper.data.local.ProfileDatabase profileDataBase = null;
    
    public final void saveProfile(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.ProfileDto profileDto) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.tomdeveloper.data.models.ProfileDto loadProfile() {
        return null;
    }
    
    public final void deleteAll() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tomdeveloper.data.local.ProfileDatabase getProfileDataBase() {
        return null;
    }
    
    public ProfileRepository(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.local.ProfileDatabase profileDataBase) {
        super();
    }
}