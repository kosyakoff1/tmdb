package android.example.tmdbclient.presentation.di.artist

import android.example.tmdbclient.domain.usecase.GetArtistsUseCase
import android.example.tmdbclient.domain.usecase.UpdateArtistsUseCase
import android.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase,
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}