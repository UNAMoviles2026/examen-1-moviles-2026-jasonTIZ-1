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
import com.moviles.examenmoviles.model.Reservation
import com.moviles.examenmoviles.ui.components.EmptyState
import com.moviles.examenmoviles.ui.components.ReservationCard

@Composable
fun ReservationsScreen(
    reservations: List<Reservation>,
    modifier: Modifier = Modifier
) {
    if (reservations.isEmpty()) {
        EmptyState(
            title = "No reservations yet",
            message = "Reserve a space from detail view to see it here.",
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
            text = "Reservation history",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 18.dp, bottom = 4.dp)
        )
        Text(
            text = "Your simulated bookings in this session",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(reservations, key = { it.id }) { reservation ->
                ReservationCard(
                    reservation = reservation,
                    modifier = Modifier.padding(horizontal = 0.dp)
                )
            }
        }
    }
}

