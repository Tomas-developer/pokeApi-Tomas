package com.tomdeveloper.data.local

import androidx.room.*
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.data.models.ProfileDto

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(transactions: ProfileDto)

    @Query("SELECT * FROM ${Constants.TABLE_PROFILE}")
    fun getAll():ProfileDto?

    // no uso la anotacion @Delete ya que me obliga a pasar el objeto que deseo borrar, y como
    // perfil de usuario solo quiero uno no me interesa tener mas, y el id es el nombre, si el
    // usuario se equivoca me meteria dos perfiles con lo cual lo borro :D
    @Query("DELETE FROM ${Constants.TABLE_PROFILE}")
    fun deleteAll()
}