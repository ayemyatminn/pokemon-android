package com.example.pokmonapp.ui.pokemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokmonapp.data.local.BackpackEntity
import com.example.pokmonapp.viewModel.BackpackViewModel
import com.example.pokmonapp.viewModel.PokemonViewModel

@Composable
fun PokemonListScreen(
    viewModel: PokemonViewModel = viewModel(),
    backpackViewModel: BackpackViewModel,
    modifier: Modifier = Modifier,) {

    val pokemonList by viewModel.pokemon.collectAsState()
    var searchText by remember { mutableStateOf("") }

    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "🚀 Pokédex",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "A–Z",
                color = Color(0xFF2979FF),
                modifier = Modifier.clickable {
                    viewModel.toggleSort()
                }
            )
        }

        TextField(
            value = searchText,
            onValueChange = {
                searchText = it
                viewModel.onSearch(it)
            },
            placeholder = { Text("Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            }
        )

        LazyColumn {
            items(pokemonList) { pokemon ->
                PokemonCard(
                    pokemon = pokemon,
                    onAddClick = {
                        backpackViewModel.addPokemon(
                            BackpackEntity(
                                id = pokemon.id,
                                name = pokemon.name,
                                imageUrl = pokemon.imageUrl,
                                types = pokemon.types
                            )
                        )
                    }
                )
            }
        }
    }
}
