package com.example.pokmonapp.data.repository

import com.example.pokmonapp.data.local.BackpackDao
import com.example.pokmonapp.data.local.BackpackEntity
import kotlinx.coroutines.flow.Flow

class BackpackRepository(
    private val dao: BackpackDao
) {
    val backpack: Flow<List<BackpackEntity>> = dao.getAllPokemon()

    suspend fun addPokemon(entity: BackpackEntity) =
        dao.insertPokemon(entity)

    suspend fun removePokemon(id: Int) =
        dao.removePokemon(id)

    suspend fun toggleFavorite(id: Int, isFavorite: Boolean) =
        dao.updateFavorite(id, isFavorite)

    suspend fun updateRating(id: Int, rating: Int) =
        dao.updateRating(id, rating)
}