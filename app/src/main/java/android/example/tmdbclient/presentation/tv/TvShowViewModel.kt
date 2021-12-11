package android.example.tmdbclient.presentation.tv

import android.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import android.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}