package android.example.tmdbclient.data.db

import android.example.tmdbclient.data.model.artist.Artist
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtistDao {

    @Query("DELETE FROM popular_artist")
    suspend fun deleteAllArtists()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artist: List<Artist>)

    @Query("SELECT * FROM popular_artist")
    suspend fun getAllArtists(): List<Artist>
}