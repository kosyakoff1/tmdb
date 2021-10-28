package android.example.tmdbclient.data.repository.artist

import android.example.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies: List<Artist>)
    suspend fun clearAll()
}