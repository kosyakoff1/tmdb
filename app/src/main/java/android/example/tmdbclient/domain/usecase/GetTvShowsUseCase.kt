package android.example.tmdbclient.domain.usecase

import android.example.tmdbclient.data.model.tvshow.TvShow
import android.example.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}