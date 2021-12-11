package android.example.tmdbclient.presentation.di.core

import android.example.tmdbclient.data.api.TMDBService
import android.example.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import android.example.tmdbclient.data.repository.artist.ArtistRemoteDataSourceImpl
import android.example.tmdbclient.data.repository.movie.MovieRemoteDataSource
import android.example.tmdbclient.data.repository.movie.MovieRemoteDataSourceImpl
import android.example.tmdbclient.data.repository.tvshow.TvShowRemoteDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}