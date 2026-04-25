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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.model.Space
import com.moviles.examenmoviles.ui.components.AvailabilityBadge
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.MetaRow
import com.moviles.examenmoviles.ui.components.PriceBadge

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
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Image(
            painter = painterResource(id = space.imageRes),
            contentDescription = space.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Text(text = space.name, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)

        Box(modifier = Modifier.fillMaxWidth()) {
            AvailabilityBadge(available = space.availability)
            PriceBadge(pricePerHour = space.pricePerHour, modifier = Modifier.align(Alignment.CenterEnd))
        }

        Text(
            text = space.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                MetaRow(
                    left = "Location",
                    right = space.location,
                    modifier = Modifier.fillMaxWidth()
                )
                MetaRow(
                    left = "Capacity",
                    right = "${space.capacity} people",
                    modifier = Modifier.fillMaxWidth()
                )
                MetaRow(
                    left = "Rate",
                    right = "$${"%.2f".format(space.pricePerHour)} per hour",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Text(
            text = if (isReserved) "This reservation is already simulated in this session." else "Reserve this space in one tap.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        AppButton(
            text = if (isReserved) "Reservation simulated" else "Simulate reservation",
            onClick = { onReserveClick(space) },
            enabled = space.availability && !isReserved
        )
    }
}



