package android.example.tmdbclient.presentation.artist

import android.example.tmdbclient.R
import android.example.tmdbclient.data.model.artist.Artist
import android.example.tmdbclient.databinding.ListItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapterViewHolder>() {
    private val artistList: ArrayList<Artist> = ArrayList()

    fun setList(list: List<Artist>) {
        artistList.clear()
        artistList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)

        return ArtistAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistAdapterViewHolder, position: Int) =
        holder.bind(artistList[position])

    override fun getItemCount(): Int = artistList.size
}

class ArtistAdapterViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(artist: Artist) {
        with(binding) {
            titleTextView.text = artist.name
            descriptionTextView.text = artist.popularity.toString()
            val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}