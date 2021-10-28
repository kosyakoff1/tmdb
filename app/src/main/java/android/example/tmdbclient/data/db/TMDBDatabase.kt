package android.example.tmdbclient.data.db

import android.example.tmdbclient.data.model.artist.Artist
import android.example.tmdbclient.data.model.movie.Movie
import android.example.tmdbclient.data.model.tvshow.TvShow
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Movie::class, TvShow::class, Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun  movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}