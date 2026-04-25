package com.moviles.examenmoviles.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.Space
import com.moviles.examenmoviles.ui.components.AppButton

@Composable
fun SpaceDetailScreen(
    space: Space?,
    isReserved: Boolean,
    onReserveClick: (Space) -> Unit,
    modifier: Modifier = Modifier
) {
    if (space == null) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Space not found")
        }
        return
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = space.imageRes),
            contentDescription = space.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Crop
        )

        Text(text = space.name, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Text(text = space.description, style = MaterialTheme.typography.bodyLarge)

        Text(text = "Location: ${space.location}")
        Text(text = "Capacity: ${space.capacity} people")
        Text(text = "Price per hour: $${"%.2f".format(space.pricePerHour)}")
        Text(
            text = "Availability: ${if (space.availability) "Available" else "Not available"}",
            color = if (space.availability) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )

        AppButton(
            text = if (isReserved) "Reservation simulated" else "Simulate reservation",
            onClick = { onReserveClick(space) },
            enabled = space.availability && !isReserved
        )
    }
}



