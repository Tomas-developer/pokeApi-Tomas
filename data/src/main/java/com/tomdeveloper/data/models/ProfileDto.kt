package com.tomdeveloper.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomdeveloper.data.commons.Constants

@Entity(tableName = Constants.TABLE_PROFILE)
data class ProfileDto (
        @PrimaryKey var name: String,
        var surname: String?,
        var age: Int?,
        var numBadget: Int?)