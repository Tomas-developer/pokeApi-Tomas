package com.tomdeveloper.data.repositories

import com.tomdeveloper.data.local.ProfileDatabase
import com.tomdeveloper.data.models.ProfileDto

class ProfileRepository(val profileDataBase: ProfileDatabase) {



    fun saveProfile(profileDto: ProfileDto){
        // borro el perfil antiguo por si el usuario mete otro nombre ya que solo
        // va a almacenar un perfil del usuario y despues inserto el nuevo
        profileDataBase.profileDao().deleteAll()
        profileDataBase.profileDao().save(profileDto)
    }

    fun loadProfile():ProfileDto?{
        return profileDataBase.profileDao().getAll()
    }

    fun deleteAll(){
        profileDataBase.profileDao().deleteAll()
    }

}