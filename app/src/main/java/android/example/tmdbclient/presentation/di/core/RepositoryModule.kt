package android.example.tmdbclient.presentation.di.core

import android.example.tmdbclient.data.repository.artist.ArtistCacheDataSource
import android.example.tmdbclient.data.repository.artist.ArtistLocalDataSource
import android.example.tmdbclient.data.repository.artist.ArtistRemoteDataSource
import android.example.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import android.example.tmdbclient.data.repository.movie.MovieCacheDataSource
import android.example.tmdbclient.data.repository.movie.MovieLocalDataSource
import android.example.tmdbclient.data.repository.movie.MovieRemoteDataSource
import android.example.tmdbclient.data.repository.movie.MovieRepositoryImpl
import android.example.tmdbclient.data.repository.tvshow.TvShowCacheDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowLocalDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowRemoteDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import android.example.tmdbclient.domain.repository.ArtistRepository
import android.example.tmdbclient.domain.repository.MovieRepository
import android.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource,
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource)
    }
}