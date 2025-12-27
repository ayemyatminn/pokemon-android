package com.example.pokmonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokmonapp.data.local.AppDatabase
import com.example.pokmonapp.data.repository.BackpackRepository
import com.example.pokmonapp.ui.PokemonApp
import com.example.pokmonapp.ui.pokemon.PokemonListScreen
import com.example.pokmonapp.ui.theme.PokémonAppTheme
import com.example.pokmonapp.viewModel.BackpackViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current

            val database = remember {
                AppDatabase.getDatabase(context)
            }

            val backpackRepository = remember {
                BackpackRepository(database.backpackDao())
            }

            val backpackViewModel = remember {
                BackpackViewModel(backpackRepository)
            }

            PokemonApp(backpackViewModel)
        }
    }
}