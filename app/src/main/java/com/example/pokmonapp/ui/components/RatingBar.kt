package com.example.pokmonapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RatingBar(
    rating: Int,
    maxRating: Int = 5,
    onRatingSelected: (Int) -> Unit
) {
    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= rating)
                    Icons.Filled.Star
                else
                    Icons.Outlined.StarBorder,
                contentDescription = null,
                tint = Color(0xFFFFA000),
                modifier = Modifier.clickable {
                    onRatingSelected(i)
                }
            )
        }
    }
}