package com.aiyaz.tmbdclient.presentation.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aiyaz.tmbdclient.R
import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class PeopleAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val peopleList: ArrayList<People> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(peopleList[position])
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    fun setPeopleList(people: List<People>){
        peopleList.clear()
        peopleList.addAll(people)
    }

}

class MyViewHolder(var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(people: People){
        binding.titleTextView.text = people.name
        binding.descriptionTextView.text = people.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500" + people.profilePath
        Glide.with(binding.imageView.context)
            .load(posterUrl)
            .into(binding.imageView)
    }
}

