package com.example.pokmonapp.data.model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val imageUrl: String
)