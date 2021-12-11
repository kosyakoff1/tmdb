package android.example.tmdbclient.presentation.artist

import android.example.tmdbclient.domain.usecase.GetArtistsUseCase
import android.example.tmdbclient.domain.usecase.UpdateArtistsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
) : ViewModel() {

    fun getArtists() = liveData {
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}