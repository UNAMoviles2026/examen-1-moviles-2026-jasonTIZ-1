package com.moviles.examenmoviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.ui.components.BottomBar
import com.moviles.examenmoviles.ui.screens.ReservationsScreen
import com.moviles.examenmoviles.ui.screens.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.SpacesListScreen
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme
import com.moviles.examenmoviles.ui.viewmodel.CoworkingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenMovilesTheme {
                CoworkingApp()
            }
        }
    }
}

@Composable
fun CoworkingApp() {
    val navController = rememberNavController()
    val viewModel: CoworkingViewModel = viewModel()
    val spaces = viewModel.spaces()
    val reservationsState = viewModel.reservations.collectAsState()
    val reservations = reservationsState.value
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomBar(currentRoute = currentRoute) { route ->
                navController.navigate(route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "spaces",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("spaces") {
                SpacesListScreen(
                    spaces = spaces,
                    onSpaceClick = { spaceId -> navController.navigate("space/$spaceId") }
                )
            }

            composable("reservations") {
                ReservationsScreen(reservations = reservations)
            }

            composable(
                route = "space/{spaceId}",
                arguments = listOf(navArgument("spaceId") { defaultValue = -1 })
            ) { backStackEntry ->
                val spaceId = backStackEntry.arguments?.getInt("spaceId")
                val selectedSpace = viewModel.findSpaceById(spaceId)
                SpaceDetailScreen(
                    space = selectedSpace,
                    isReserved = selectedSpace?.let { viewModel.isReserved(it.id) } ?: false,
                    onReserveClick = { viewModel.reserveSpace(it) }
                )
            }
        }
    }
}