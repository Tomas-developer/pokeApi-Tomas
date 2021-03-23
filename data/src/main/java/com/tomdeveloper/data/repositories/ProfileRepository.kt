package com.tomdeveloper.data.repositories

import com.tomdeveloper.data.local.ProfileDatabase
import com.tomdeveloper.data.models.ProfileDto

class ProfileRepository(val profileDataBase: ProfileDatabase) {

    fun saveProfile(profileDto: ProfileDto){
        profileDataBase.profileDao().save(profileDto)
    }

    fun loadProfile():ProfileDto?{
        return profileDataBase.profileDao().getAll()
    }

}