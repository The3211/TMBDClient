package com.aiyaz.tmbdclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aiyaz.tmbdclient.R
import com.aiyaz.tmbdclient.databinding.ActivityTvShowBinding
import com.aiyaz.tmbdclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var binding: ActivityTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        initializeRecyclerview()
    }

    private fun initializeRecyclerview(){
        binding.tvshowRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvshowRecyclerview.adapter = adapter
        displayTvShow()
    }


    private fun displayTvShow(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        viewModel.getTvShowList().observe(this){
            if(!it.isNullOrEmpty()){
                adapter.setTvShowList(it)
                adapter.notifyDataSetChanged()
            }
            binding.tvshowProgressBar.visibility = View.GONE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update ->{
                updateTvShow()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShow(){
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateTvShowList()
        response.observe(this){
            if(!it.isNullOrEmpty()){
                adapter.setTvShowList(it)
                adapter.notifyDataSetChanged()
            }
            binding.tvshowProgressBar.visibility = View.GONE
        }

    }


}