package com.tomdeveloper.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.models.ProfileDto

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(transactions: ProfileDto)

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    fun getAll():ProfileDto?
}