package com.example.pokmonapp.data.local

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        if (value.isEmpty()) return emptyList()
        return value.split(",")
    }
}