package com.tomdeveloper.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tomdeveloper.data.models.Types

class Converters {

    @TypeConverter
    fun toJson(value: List<Types>):String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toList(value: String): List<Types>{
        val ty= object : TypeToken<ArrayList<Types>>() {}.type
        return Gson().fromJson(value, ty)
    }
}