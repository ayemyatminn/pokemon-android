package com.example.pokmonapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokmonapp.data.model.Pokemon
import com.example.pokmonapp.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()
    private val _allPokemon = MutableStateFlow<List<Pokemon>>(emptyList())
    private val _searchQuery = MutableStateFlow("")
    private val _isAscending = MutableStateFlow(true)
    val pokemon: StateFlow<List<Pokemon>> = combine(_allPokemon, _searchQuery, _isAscending) { list, query, asc ->
        list
            .filter { it.name.contains(query, ignoreCase = true) }
            .sortedBy { if (asc) it.name else it.name.reversed() }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    init {
        loadPokemon()
    }

    private fun loadPokemon() {
        viewModelScope.launch {
            _allPokemon.value = repository.fetchGen1Pokemon()
        }
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
    }

    fun toggleSort() {
        _isAscending.value = !_isAscending.value
    }
}