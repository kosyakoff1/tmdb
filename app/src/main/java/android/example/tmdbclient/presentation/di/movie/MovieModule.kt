package android.example.tmdbclient.presentation.di.movie

import android.example.tmdbclient.domain.usecase.GetMoviesUseCase
import android.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import android.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase,
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}