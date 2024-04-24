package com.feature.playing_movie.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.playing_movie.domain.use_cases.GetNowPlayingMovieUseCase
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
class NowPlayingMovieViewModel @Inject constructor(private val getNowPlayingMovieUseCase: GetNowPlayingMovieUseCase) :
    ViewModel() {
    private val _nowPlayingMovieList = MutableStateFlow(NowPlayingMovieStateHolder())
    val nowPlayingMovieList: StateFlow<NowPlayingMovieStateHolder> get() = _nowPlayingMovieList

    private val _page: MutableStateFlow<Int> = MutableStateFlow(1)
    val page: StateFlow<Int> get() = _page

    fun setPage(page: Int) {
        _page.value = page
    }

    private val API_KEY = "6e75acc6bb8cb7c2e71901cd807914b5"

    init {
        viewModelScope.launch {
            page.debounce(100).collectLatest {
                getNowPlayingList(it)
            }
        }
    }

    fun getNowPlayingList(page: Int) = viewModelScope.launch {
        getNowPlayingMovieUseCase(page).onEach {
            when (it) {
                is UiEvent.Loading -> {
                    _nowPlayingMovieList.value = NowPlayingMovieStateHolder(isLoading = true)
                }

                is UiEvent.Success -> {
                    _nowPlayingMovieList.value = NowPlayingMovieStateHolder(data = it.data)
                }

                is UiEvent.Error -> {
                    _nowPlayingMovieList.value =
                        NowPlayingMovieStateHolder(error = it.message.toString())
                }

            }
        }.launchIn(viewModelScope)
    }

}
