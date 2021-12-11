package android.example.tmdbclient.data.repository.artist

import android.example.tmdbclient.data.model.artist.Artist
import android.example.tmdbclient.domain.repository.ArtistRepository
import android.util.Log
import java.lang.Exception

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource,
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)

        return newListOfArtists
    }

    suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.localizedMessage.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDb(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.localizedMessage.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.localizedMessage.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDb()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}