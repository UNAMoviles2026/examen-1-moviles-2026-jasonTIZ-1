package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.Space
import com.moviles.examenmoviles.ui.components.SpaceCard

@Composable
fun SpacesListScreen(
    spaces: List<Space>,
    onSpaceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (spaces.isEmpty()) {
        Text(
            text = "No coworking spaces available.",
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        return
    }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(spaces, key = { it.id }) { space ->
            SpaceCard(space = space, onClick = { onSpaceClick(space.id) })
        }
    }
}

