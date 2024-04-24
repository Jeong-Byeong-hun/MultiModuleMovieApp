package com.feature.playing_movie.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NowPlayingMovieScreen(viewModel: NowPlayingMovieViewModel, navController: NavHostController) {

    val result = viewModel.nowPlayingMovieList.collectAsState().value
    val page = viewModel.page.collectAsState()

    Scaffold(topBar = {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)) {
            Text(
                modifier = Modifier,
                text = page.value.toString()
            )
            
            Button(onClick = { viewModel.setPage(page.value.toInt() + 1) }) {
                Text(text = "다음거 보기")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable {
                    if (page.value > 1) {
                        viewModel.setPage(page.value.toInt() - 1)
                    }
                })
            Icon(
                modifier = Modifier.clickable {
                    viewModel.setPage(page.value.toInt() + 1)
                },
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
            )
        }

    }) {

        it
        if (result.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        if (result.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = result.error)
            }
        }

        result.data?.let {
            if (it.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Nothing Found")
                }
            } else {

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp),
                    content = {
                        items(it) {
                            Column(
                                modifier = Modifier
                                    .height(300.dp)
                                    .border(width = 1.dp, color = Color.White)
                            ) {
                                AsyncImage(
                                    modifier = Modifier.clickable {
                                        navController.navigate("movie_details/${it.id}")
                                    },
                                    model = it.imageUrl,
                                    contentDescription = null,
                                    contentScale = ContentScale.Fit
                                )

                                Text(
                                    text = it.title,
                                    fontSize = 13.sp,
                                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                                )
                            }
                        }
                    })

            }
        }
    }

}