package com.example.pokmonapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "backpack")
data class BackpackEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>,
    val isFavorite: Boolean = false,
    val rating: Int = 0
)
