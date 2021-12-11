package android.example.tmdbclient.data.repository.tvshow

import android.example.tmdbclient.data.model.tvshow.TvShow

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}