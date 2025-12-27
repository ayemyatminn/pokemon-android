package com.example.pokmonapp.data.remote

data class PokemonListResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>,
    val sprites: PokemonSprites
)

data class PokemonTypeSlot(
    val type: PokemonType
)

data class PokemonType(
    val name: String
)

data class PokemonSprites(
    val front_default: String?
)