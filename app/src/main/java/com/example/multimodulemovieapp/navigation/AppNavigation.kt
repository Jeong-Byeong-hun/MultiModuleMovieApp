package com.example.multimodulemovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.MovieFeature


@Composable
fun AppNavGraph(navController: NavHostController, navigationProviders: NavigationProviders) {
    NavHost(navController = navController, startDestination = MovieFeature.nestedRoute) {
        navigationProviders.movieApi.registerGraph(
            navController, this
        )

        navigationProviders.movieDetailsApi.registerGraph(
            navController, this
        )
    }
}