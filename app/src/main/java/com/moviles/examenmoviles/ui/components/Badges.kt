package com.moviles.examenmoviles.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviles.examenmoviles.ui.theme.Success
import com.moviles.examenmoviles.ui.theme.SuccessContainer

@Composable
fun AvailabilityBadge(
    available: Boolean,
    modifier: Modifier = Modifier
) {
    val text = if (available) "Available" else "Not available"
    val background = if (available) SuccessContainer else MaterialTheme.colorScheme.error.copy(alpha = 0.2f)
    val color = if (available) Success else MaterialTheme.colorScheme.error

    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.labelLarge,
        modifier = modifier
            .background(background, RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}

@Composable
fun PriceBadge(
    pricePerHour: Double,
    modifier: Modifier = Modifier
) {
    Text(
        text = "$${"%.2f".format(pricePerHour)}/h",
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        modifier = modifier
            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(12.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}

@Composable
fun ReservationStatusBadge(
    status: String,
    modifier: Modifier = Modifier
) {
    val normalized = status.lowercase()
    val isConfirmed = normalized == "confirmed"

    Text(
        text = status.replaceFirstChar { it.uppercase() },
        style = MaterialTheme.typography.labelSmall,
        color = if (isConfirmed) Success else MaterialTheme.colorScheme.error,
        modifier = modifier
            .background(
                if (isConfirmed) SuccessContainer else MaterialTheme.colorScheme.error.copy(alpha = 0.2f),
                RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    )
}

@Composable
fun MetaRow(
    left: String,
    right: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = left, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = right, style = MaterialTheme.typography.bodyMedium)
    }
}


