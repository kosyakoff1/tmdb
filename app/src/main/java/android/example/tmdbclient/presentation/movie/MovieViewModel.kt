package android.example.tmdbclient.presentation.movie

import android.example.tmdbclient.domain.usecase.GetMoviesUseCase
import android.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}