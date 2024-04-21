package com.feature.movie.ui.navigation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.moive.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) :
    ViewModel() {

    private val _movieList = MutableStateFlow(MovieSearchStateHolder())

    val movieList: StateFlow<MovieSearchStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query


    fun setQuery(s: String) {
        _query.value = s
    }

    private val API_KEY = "6e75acc6bb8cb7c2e71901cd807914b5"

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(API_KEY, it)
            }
        }
    }

    fun getMovieList(apiKey: String, q: String) = viewModelScope.launch {
        getMovieListUseCase(apiKey, q).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _movieList.value = MovieSearchStateHolder(isLoading = true)
                }

                is UiEvent.Error -> {
                    _movieList.value = MovieSearchStateHolder(error = it.message.toString())
                }

                is UiEvent.Success -> {
                    _movieList.value = MovieSearchStateHolder(data = it.data)
                }


            }
        }.launchIn(viewModelScope)
    }
}