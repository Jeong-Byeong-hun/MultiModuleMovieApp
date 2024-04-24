package com.feature.playing_movie.ui

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.NowPlayingMovieFeature
import com.core.feature_api.FeatureApi
import com.feature.playing_movie.ui.screen.NowPlayingMovieScreen
import com.feature.playing_movie.ui.screen.NowPlayingMovieViewModel

internal object InternalMovieFeatureApi : FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = NowPlayingMovieFeature.nowPlayingScreenRoute,
            route = NowPlayingMovieFeature.nestedRoute
        ) {
            composable(NowPlayingMovieFeature.nowPlayingScreenRoute) {

                val viewModel = hiltViewModel<NowPlayingMovieViewModel>()
                NowPlayingMovieScreen(viewModel = viewModel, navController)
            }
        }

    }
}