package com.moviles.examenmoviles.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

data class BottomNavItem(
    val route: String,
    val title: String
)

@Composable
fun BottomBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    val items = listOf(
        BottomNavItem(route = "spaces", title = "Spaces"),
        BottomNavItem(route = "reservations", title = "Reservations")
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 6.dp
    ) {
        items.forEach { item ->
            val selected = when {
                currentRoute == item.route -> true
                item.route == "spaces" && currentRoute?.startsWith("space/") == true -> true
                else -> false
            }

            NavigationBarItem(
                selected = selected,
                onClick = { onNavigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                icon = {
                    val icon = if (item.route == "spaces") Icons.Filled.Home else Icons.Filled.Bookmark
                    Icon(imageVector = icon, contentDescription = item.title)
                },
                label = { Text(item.title) }
            )
        }
    }
}



