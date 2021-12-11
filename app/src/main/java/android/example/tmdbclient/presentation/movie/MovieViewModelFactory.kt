package android.example.tmdbclient.presentation.movie

import android.example.tmdbclient.domain.usecase.GetMoviesUseCase
import android.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}