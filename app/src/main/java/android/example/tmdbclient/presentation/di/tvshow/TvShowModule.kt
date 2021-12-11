package android.example.tmdbclient.presentation.di.tvshow

import android.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import android.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import android.example.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase,
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}