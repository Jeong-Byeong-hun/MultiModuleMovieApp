package com.feature.playing_movie.domain.use_cases

import com.core.common.UiEvent
import com.feature.playing_movie.domain.model.NowPlayingMovie
import com.feature.playing_movie.domain.repo.NowPlayingMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetNowPlayingMovieUseCase @Inject constructor(private val playingMovieRepo: NowPlayingMovieRepository) {
    operator fun invoke(page: Int): Flow<UiEvent<List<NowPlayingMovie>>> = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(playingMovieRepo.getPlayingMovie(page)))
    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}