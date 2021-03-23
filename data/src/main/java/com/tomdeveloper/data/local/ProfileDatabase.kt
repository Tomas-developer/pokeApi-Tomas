package com.tomdeveloper.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.commons.Constants.TABLE_NAME
import com.tomdeveloper.data.models.ProfileDto

@Database(entities = [ProfileDto::class], version = 1)
abstract class ProfileDatabase:RoomDatabase() {

    abstract fun profileDao(): ProfileDao

    companion object{
        @Volatile
        private var INSTANCE: ProfileDatabase?= null

        fun getInstance(context: Context): ProfileDatabase =
                INSTANCE ?: synchronized(this){
                    INSTANCE ?: buildDatabase(context.applicationContext).also {
                        INSTANCE = it
                    }
                }

        private fun buildDatabase(appContext: Context): ProfileDatabase{
            return Room.databaseBuilder(appContext, ProfileDatabase::class.java, TABLE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }
}