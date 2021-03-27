package com.tomdeveloper.data.models;

import java.lang.System;

@androidx.room.Entity(tableName = "profile")
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ<\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011\u00a8\u0006!"}, d2 = {"Lcom/tomdeveloper/data/models/ProfileDto;", "", "name", "", "surname", "age", "", "numBadget", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAge", "()Ljava/lang/Integer;", "setAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getNumBadget", "setNumBadget", "getSurname", "setSurname", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tomdeveloper/data/models/ProfileDto;", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class ProfileDto {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String surname;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer age;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer numBadget;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSurname() {
        return null;
    }
    
    public final void setSurname(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAge() {
        return null;
    }
    
    public final void setAge(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getNumBadget() {
        return null;
    }
    
    public final void setNumBadget(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public ProfileDto(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String surname, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numBadget) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tomdeveloper.data.models.ProfileDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String surname, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Integer numBadget) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}