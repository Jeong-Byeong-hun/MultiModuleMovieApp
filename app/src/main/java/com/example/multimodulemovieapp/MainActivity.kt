package com.example.multimodulemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.multimodulemovieapp.navigation.AppNavGraph
import com.example.multimodulemovieapp.navigation.NavigationProviders
import com.example.multimodulemovieapp.ui.theme.MultiModuleMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProviders: NavigationProviders

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiModuleMovieAppTheme {
                val navController = rememberNavController()
                App(navHostController = navController, navigationProviders)

            }
        }
    }
}

@Composable
fun App(navHostController: NavHostController, navigationProviders: NavigationProviders){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavGraph(navController = navHostController, navigationProviders = navigationProviders)
    }
}
