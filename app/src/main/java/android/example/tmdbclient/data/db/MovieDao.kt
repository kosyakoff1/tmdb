package android.example.tmdbclient.data.db

import android.example.tmdbclient.data.model.movie.Movie
import androidx.room.*


@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie")
    suspend fun getMovies(): List<Movie>
}