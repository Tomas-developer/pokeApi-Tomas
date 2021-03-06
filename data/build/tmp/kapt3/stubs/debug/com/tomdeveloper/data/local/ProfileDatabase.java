package com.tomdeveloper.data.local;

import java.lang.System;

@androidx.room.Database(entities = {com.tomdeveloper.data.models.ProfileDto.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tomdeveloper/data/local/ProfileDatabase;", "Landroidx/room/RoomDatabase;", "()V", "profileDao", "Lcom/tomdeveloper/data/local/ProfileDao;", "Companion", "data_debug"})
public abstract class ProfileDatabase extends androidx.room.RoomDatabase {
    private static volatile com.tomdeveloper.data.local.ProfileDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.tomdeveloper.data.local.ProfileDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.tomdeveloper.data.local.ProfileDao profileDao();
    
    public ProfileDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tomdeveloper/data/local/ProfileDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/tomdeveloper/data/local/ProfileDatabase;", "buildDatabase", "appContext", "Landroid/content/Context;", "getInstance", "context", "data_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.tomdeveloper.data.local.ProfileDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.tomdeveloper.data.local.ProfileDatabase buildDatabase(android.content.Context appContext) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}