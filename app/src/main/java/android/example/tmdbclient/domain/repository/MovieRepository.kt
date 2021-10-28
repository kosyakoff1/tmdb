package android.example.tmdbclient.domain.repository

import android.example.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}