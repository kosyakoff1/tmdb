package android.example.tmdbclient.presentation

import android.content.Intent
import android.example.tmdbclient.R
import android.example.tmdbclient.databinding.ActivityHomeBinding
import android.example.tmdbclient.presentation.artist.ArtistActivity
import android.example.tmdbclient.presentation.movie.MovieActivity
import android.example.tmdbclient.presentation.tv.TvShowActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}