package com.example.pokmonapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BackpackDao {

    @Query("SELECT * FROM backpack")
    fun getAllPokemon(): Flow<List<BackpackEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: BackpackEntity)

    @Query("DELETE FROM backpack WHERE id = :id")
    suspend fun removePokemon(id: Int)

    @Query("UPDATE backpack SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavorite(id: Int, isFavorite: Boolean)

    @Query("UPDATE backpack SET rating = :rating WHERE id = :id")
    suspend fun updateRating(id: Int, rating: Int)
}