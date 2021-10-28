package android.example.tmdbclient.domain.usecase

import android.example.tmdbclient.data.model.artist.Artist
import android.example.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}