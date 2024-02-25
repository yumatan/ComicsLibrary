package com.example.comicslibrary.view

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.comicslibrary.Destination
import com.example.comicslibrary.R

@Composable
fun CharactersBottomNav(navController: NavHostController) {
    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        val iconLibrary = painterResource(id = R.drawable.library)
        val iconCollection = painterResource(id = R.drawable.collection)

        NavigationRailItem(
            selected = currentDestination?.route == Destination.Library.route,
            onClick = {
                navController.navigate(Destination.Library.route) {
                    popUpTo(Destination.Library.route)
                    launchSingleTop = true
                }
            },
            icon = { Icon(painter = iconLibrary, contentDescription = null) },
            label = { Text(text = Destination.Library.route) }
        )

        NavigationRailItem(
            selected = currentDestination?.route == Destination.Collection.route,
            onClick = {
                navController.navigate(Destination.Collection.route) {
                    launchSingleTop = true
                }
            },
            icon = { Icon(painter = iconCollection, contentDescription = null) },
            label = { Text(text = Destination.Collection.route) }
        )
    }
}