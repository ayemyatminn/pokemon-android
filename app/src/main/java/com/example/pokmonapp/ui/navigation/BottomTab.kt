package com.example.pokmonapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Pokedex : BottomTab(
        route = "pokedex",
        label = "Pokédex",
        icon = Icons.Filled.Menu
    )

    object Backpack : BottomTab(
        route = "backpack",
        label = "Backpack",
        icon = Icons.Filled.ShoppingCart
    )
}