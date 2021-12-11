package android.example.tmdbclient.data.repository.tvshow

import android.example.tmdbclient.data.db.TvShowDao
import android.example.tmdbclient.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch { tvShowDao.saveTvShows(tvShows) }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch { tvShowDao.deleteAllTvShows() }
    }
}