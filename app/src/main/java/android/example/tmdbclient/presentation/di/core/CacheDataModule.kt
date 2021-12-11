package android.example.tmdbclient.presentation.di.core

import android.example.tmdbclient.data.repository.artist.ArtistCacheDataSource
import android.example.tmdbclient.data.repository.artist.ArtistCacheDataSourceImpl
import android.example.tmdbclient.data.repository.movie.MovieCacheDataSource
import android.example.tmdbclient.data.repository.movie.MovieCacheDataSourceImpl
import android.example.tmdbclient.data.repository.tvshow.TvShowCacheDataSource
import android.example.tmdbclient.data.repository.tvshow.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}