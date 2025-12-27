package com.example.pokmonapp.ui.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokmonapp.data.model.Pokemon

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onAddClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                model = pokemon.imageUrl,
                contentDescription = pokemon.name,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "#${pokemon.id} ${pokemon.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Row {
                    pokemon.types.forEach { type ->
                        TypeChip(type)
                    }
                }
            }

            IconButton(onClick = onAddClick) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add",
                    tint = Color(0xFF2979FF),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
