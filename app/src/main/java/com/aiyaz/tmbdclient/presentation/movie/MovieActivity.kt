package com.aiyaz.tmbdclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiyaz.tmbdclient.R
import com.aiyaz.tmbdclient.data.model.movie.Movie
import com.aiyaz.tmbdclient.databinding.ActivityMovieBinding
import com.aiyaz.tmbdclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory


    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        initRecyclerView()
    }


    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularFunction()
    }

    private fun displayPopularFunction(){
        binding.movieProgressBar.visibility = View.VISIBLE
        movieViewModel.getMovies().observe(this) {
            if(it != null){
                adapter.setMovieList(it)
                adapter.notifyItemRangeInserted(0,it.size)
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        }
    }
}