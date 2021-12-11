package android.example.tmdbclient.presentation

import android.app.Application
import android.example.tmdbclient.BuildConfig
import android.example.tmdbclient.presentation.di.Injector
import android.example.tmdbclient.presentation.di.artist.ArtistSubComponent
import android.example.tmdbclient.presentation.di.core.*
import android.example.tmdbclient.presentation.di.movie.MovieSubComponent
import android.example.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }
}