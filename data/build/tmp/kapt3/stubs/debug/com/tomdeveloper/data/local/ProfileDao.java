package com.tomdeveloper.data.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\'\u00a8\u0006\b"}, d2 = {"Lcom/tomdeveloper/data/local/ProfileDao;", "", "deleteAll", "", "getAll", "Lcom/tomdeveloper/data/models/ProfileDto;", "save", "transactions", "data_debug"})
public abstract interface ProfileDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void save(@org.jetbrains.annotations.NotNull()
    com.tomdeveloper.data.models.ProfileDto transactions);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM profile")
    public abstract com.tomdeveloper.data.models.ProfileDto getAll();
    
    @androidx.room.Query(value = "DELETE FROM profile")
    public abstract void deleteAll();
}