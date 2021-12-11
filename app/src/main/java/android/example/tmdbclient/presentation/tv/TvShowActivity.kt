package android.example.tmdbclient.presentation.tv

import android.example.tmdbclient.R
import android.example.tmdbclient.databinding.ActivityTvShowBinding
import android.example.tmdbclient.presentation.di.Injector
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding

    @Inject
    lateinit var viewModelFactory: TvShowViewModelFactory
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Injector).createTvShowSubComponent().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        viewModel = ViewModelProvider(this, viewModelFactory).get(TvShowViewModel::class.java)

        initRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        with(binding) {
            tvShowProgressBar.visibility = View.VISIBLE
            val response = viewModel.updateTvShows()
            response.observe(this@TvShowActivity, {
                if (it != null) {
                    adapter.setList(it)
                    adapter.notifyDataSetChanged()
                }

                binding.tvShowProgressBar.visibility = View.GONE
            })
        }
    }

    private fun initRecyclerView() {
        with(binding) {
            tvShowRecyclerView.layoutManager = LinearLayoutManager(this@TvShowActivity)
            adapter = TvShowAdapter()
            tvShowRecyclerView.adapter = adapter

            displayPopularTvShows()
        }
    }

    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response = viewModel.getTvShows()
        response.observe(this, {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast
                    .makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
                    .show()
            }
            binding.tvShowProgressBar.visibility = View.GONE
        })
    }
}