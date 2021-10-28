package android.example.tmdbclient.domain.usecase

import android.example.tmdbclient.data.model.movie.Movie
import android.example.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}