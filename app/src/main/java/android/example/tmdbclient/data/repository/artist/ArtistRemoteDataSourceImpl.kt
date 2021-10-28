package android.example.tmdbclient.data.repository.artist

import android.example.tmdbclient.data.api.TMDBService
import android.example.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}