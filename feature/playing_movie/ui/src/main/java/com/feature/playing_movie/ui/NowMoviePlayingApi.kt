package com.feature.playing_movie.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface NowMoviePlayingApi : FeatureApi {

}

class NowMoviePlayingApiImpl : NowMoviePlayingApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }
}