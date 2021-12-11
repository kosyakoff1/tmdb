package android.example.tmdbclient.presentation.di

import android.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import android.example.tmdbclient.presentation.di.movie.MovieSubComponent
import android.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}