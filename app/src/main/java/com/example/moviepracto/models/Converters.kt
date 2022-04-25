package com.example.moviepracto.models

import androidx.room.TypeConverter

class Converters
{
    @TypeConverter
    fun fromListIntToString(value: List<Int>?) : String? {
        return value?.joinToString(separator = ",")
    }

    @TypeConverter
    fun fromStringToListInt(value: String?) : List<Int>? {
        return value?.split(",")?.map { it.trim().toInt() }
    }
}