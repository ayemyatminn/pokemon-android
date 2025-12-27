package com.example.pokmonapp.data.repository

import com.example.pokmonapp.data.model.Pokemon
import com.example.pokmonapp.data.remote.RetrofitClient

class PokemonRepository {

    private val api = RetrofitClient.api

    suspend fun fetchGen1Pokemon(): List<Pokemon> {
        val listResponse = api.getPokemonList()
        return listResponse.results.map { result ->
            val detail = api.getPokemonDetail(result.name)
            Pokemon(
                id = detail.id,
                name = detail.name,
                types = detail.types.map { it.type.name },
                imageUrl = detail.sprites.front_default ?: ""
            )
        }
    }
}