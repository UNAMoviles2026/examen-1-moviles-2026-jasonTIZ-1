package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.Space
import com.moviles.examenmoviles.ui.components.EmptyState
import com.moviles.examenmoviles.ui.components.SpaceCard

@Composable
fun SpacesListScreen(
    spaces: List<Space>,
    onSpaceClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (spaces.isEmpty()) {
        EmptyState(
            title = "No spaces available",
            message = "Try again later or refresh mock data.",
            modifier = modifier.fillMaxSize()
        )
        return
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Find your next workspace",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 18.dp, bottom = 6.dp)
        )
        Text(
            text = "Explore available coworking spaces",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(spaces, key = { it.id }) { space ->
                SpaceCard(space = space, onClick = { onSpaceClick(space.id) })
            }
        }
    }
}

