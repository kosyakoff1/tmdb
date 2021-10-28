package android.example.tmdbclient.data.db

import android.example.tmdbclient.data.model.tvshow.TvShow
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM tv_show")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tv_show")
    suspend fun getTvShows(): List<TvShow>
}