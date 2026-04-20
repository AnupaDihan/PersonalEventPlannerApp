package com.example.personaleventplannerapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.personaleventplannerapp.screen.EventListScreen
import com.example.personaleventplannerapp.screen.AddEditEventScreen

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object EventList : Screen("event_list", "Events", Icons.Default.List)
    object AddEvent : Screen("add_event", "Add Event", Icons.Default.Add)
    object EditEvent : Screen("edit_event/{eventId}", "Edit Event", Icons.Default.Add) {
        fun passId(id: Long): String = "edit_event/$id"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val items = listOf(
        Screen.EventList,
        Screen.AddEvent
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.EventList.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.EventList.route) {
                EventListScreen(navController = navController)
            }

            composable(Screen.AddEvent.route) {
                AddEditEventScreen(navController = navController, eventId = null)
            }

            composable(
                Screen.EditEvent.route,
                arguments = listOf(navArgument("eventId") { type = NavType.LongType })
            ) { backStackEntry ->
                val eventId = backStackEntry.arguments?.getLong("eventId")
                AddEditEventScreen(
                    navController = navController,
                    eventId = eventId
                )
            }
        }
    }
}
