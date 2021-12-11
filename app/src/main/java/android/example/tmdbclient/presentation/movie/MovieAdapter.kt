package android.example.tmdbclient.presentation.movie

import android.example.tmdbclient.R
import android.example.tmdbclient.data.model.movie.Movie
import android.example.tmdbclient.databinding.ListItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movielist = ArrayList<Movie>()
    fun setList(movies: List<Movie>) {
        movielist.clear()
        movielist.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false)

        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movielist[position])
    }

    override fun getItemCount(): Int = movielist.size
}

class MovieViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)
    }
}