package android.example.tmdbclient.presentation.tv

import android.example.tmdbclient.R
import android.example.tmdbclient.data.model.tvshow.TvShow
import android.example.tmdbclient.databinding.ListItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapterViewHolder>() {
    private val itemList = ArrayList<TvShow>()

    fun setList(list: List<TvShow>) {
        itemList.clear()
        itemList.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowAdapterViewHolder {

        val binding = DataBindingUtil.inflate<ListItemBinding>(LayoutInflater.from(parent.context),
            R.layout.list_item, parent, false)
        return TvShowAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowAdapterViewHolder, position: Int) =
        holder.bind(itemList[position])

    override fun getItemCount(): Int = itemList.size
}

class TvShowAdapterViewHolder(private val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow: TvShow) {
        with(binding) {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
            Glide.with(imageView.context).load(posterURL).into(imageView)
        }
    }
}