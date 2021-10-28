package android.example.tmdbclient.domain.usecase

import android.example.tmdbclient.data.model.movie.Movie
import android.example.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}