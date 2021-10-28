package android.example.tmdbclient.data.repository.movie

import android.example.tmdbclient.data.api.TMDBService
import android.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}