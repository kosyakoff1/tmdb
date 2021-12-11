package android.example.tmdbclient.presentation.artist

import android.example.tmdbclient.R
import android.example.tmdbclient.databinding.ActivityArtistBinding
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

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as Injector).createArtistSubComponent().inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        viewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter

        displayPopularArtists()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateArtists()
        response.observe(this, {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()

            }

            binding.artistProgressBar.visibility = View.GONE
        })
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getArtists()
        responseLiveData.observe(this, {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast
                    .makeText(applicationContext, "No data available", Toast.LENGTH_LONG)
                    .show()
            }
            binding.artistProgressBar.visibility = View.GONE
        })
    }
}