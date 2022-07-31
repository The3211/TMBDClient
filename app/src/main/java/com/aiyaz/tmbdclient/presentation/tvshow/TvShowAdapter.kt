package com.aiyaz.tmbdclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiyaz.tmbdclient.data.model.tvshow.TVShow
import com.aiyaz.tmbdclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val tvShowList = ArrayList<TVShow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ListItemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    fun setTvShowList(list: List<TVShow>){
        tvShowList.clear()
        tvShowList.addAll(list)
    }

}


class MyViewHolder(var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TVShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}

