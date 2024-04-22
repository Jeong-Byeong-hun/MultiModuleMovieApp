package com.feature.movie_details.ui.Screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_details.domain.use_cases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailsStateHolder())
    val movieDetails: State<MovieDetailsStateHolder> get() = _movieDetails

    private val API_KEY = "6e75acc6bb8cb7c2e71901cd807914b5"

    init {
        viewModelScope.launch {
            savedStateHandle.getStateFlow("id", "").collect {
                it?.let {
                    getMovieDetails(it, API_KEY)
                }
            }
        }
    }

    fun getMovieDetails(id: String, apiKey: String) {
        getMovieDetailsUseCase(id, apiKey).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieDetails.value = MovieDetailsStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieDetails.value = MovieDetailsStateHolder(error = it.message.toString())
                }

                is UiEvent.Success -> {
                    _movieDetails.value = MovieDetailsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}