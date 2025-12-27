package com.example.pokmonapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.pokmonapp.ui.backpack.BackpackScreen
import com.example.pokmonapp.ui.navigation.BottomTab
import com.example.pokmonapp.ui.pokemon.PokemonListScreen
import com.example.pokmonapp.viewModel.BackpackViewModel

@Composable
fun PokemonApp(
    backpackViewModel: BackpackViewModel
) {
    var selectedTab by remember { mutableStateOf<BottomTab>(BottomTab.Pokedex) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                listOf(BottomTab.Pokedex, BottomTab.Backpack).forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { paddingValues ->

        when (selectedTab) {
            BottomTab.Pokedex -> {
                PokemonListScreen(
                    backpackViewModel = backpackViewModel,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                )
            }

            BottomTab.Backpack -> {
                BackpackScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    backpackViewModel = backpackViewModel
                )
            }
        }
    }
}
