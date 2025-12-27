package com.example.pokmonapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokmonapp.data.local.BackpackEntity
import com.example.pokmonapp.data.repository.BackpackRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BackpackViewModel(private val repository: BackpackRepository) : ViewModel() {

    val backpack = repository.backpack
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addPokemon(entity: BackpackEntity) {
        viewModelScope.launch {
            repository.addPokemon(entity)
        }
    }

    fun toggleFavorite(pokemon: BackpackEntity) {
        viewModelScope.launch {
            repository.toggleFavorite(pokemon.id, !pokemon.isFavorite)
        }
    }

    fun updateRating(pokemon: BackpackEntity, rating: Int) {
        viewModelScope.launch {
            repository.updateRating(pokemon.id, rating)
        }
    }

    fun removePokemon(id: Int) {
        viewModelScope.launch {
            repository.removePokemon(id)
        }
    }
}