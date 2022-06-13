package com.aiyaz.tmbdclient.domain.usecase

import com.aiyaz.tmbdclient.data.model.tvshow.TVShow
import com.aiyaz.tmbdclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TVShow>? = tvShowRepository.updateTvShow()
}