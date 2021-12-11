package android.example.tmdbclient.data.repository.tvshow

import android.example.tmdbclient.data.api.TMDBService
import android.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}