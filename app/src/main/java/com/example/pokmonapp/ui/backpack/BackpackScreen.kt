package com.example.pokmonapp.ui.backpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokmonapp.viewModel.BackpackViewModel

@Composable
fun BackpackScreen(
    backpackViewModel: BackpackViewModel,
    modifier: Modifier = Modifier,
) {
    val backpackList by backpackViewModel.backpack.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "🎒 My Backpack",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(backpackList) { pokemon ->
                BackpackRow(
                    pokemon = pokemon,
                    onFavoriteClick = {
                        backpackViewModel.toggleFavorite(pokemon)
                    },
                    onRatingChange = {
                        backpackViewModel.updateRating(pokemon, it)
                    },
                    onRemoveClick = {
                        backpackViewModel.removePokemon(pokemon.id)
                    }
                )
            }
        }
    }
}