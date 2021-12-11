package android.example.tmdbclient.presentation.di.core

import android.example.tmdbclient.data.db.ArtistDao
import android.example.tmdbclient.data.db.MovieDao
import android.example.tmdbclient.data.db.TvShowDao
import android.example.tmdbclient.data.repository.artist.ArtistLocalDataSource
import android.example.tmdbclient.data.repository.artist.ArtistLocalDataSourceImpl
import android.example.tmdbclient.data.repository.movie.MovieLocalDataSource
import android.example.tmdbclient.data.repository.movie.MovieLocalDataSourceImpl
import android.example.tmdbclient.data.repository.tvshow.TvShowLocalDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}