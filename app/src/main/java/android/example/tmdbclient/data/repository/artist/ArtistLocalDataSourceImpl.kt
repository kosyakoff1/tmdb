package android.example.tmdbclient.data.repository.artist

import android.example.tmdbclient.data.db.ArtistDao
import android.example.tmdbclient.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getAllArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch { artistDao.saveArtists(artists) }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { artistDao.deleteAllArtists() }
    }
}