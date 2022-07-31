package com.aiyaz.tmbdclient.presentation.people

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
import com.aiyaz.tmbdclient.databinding.ActivityPeopleBinding
import com.aiyaz.tmbdclient.presentation.di.Injector
import javax.inject.Inject

class PeopleActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: PeopleViewModelFactory

    private lateinit var binding: ActivityPeopleBinding
    private lateinit var peopleViewModel: PeopleViewModel

    private lateinit var adapter: PeopleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_people)
        (application as Injector).createPeopleSubComponent().inject(this)
        peopleViewModel = ViewModelProvider(this, factory)[PeopleViewModel::class.java]
        initRecyclerView()
    }


    private fun initRecyclerView(){
        binding.peopleRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = PeopleAdapter()
        binding.peopleRecyclerview.adapter = adapter
        displayPeople()
    }

    private fun displayPeople(){
        binding.peopleProgressBar.visibility = View.VISIBLE
        peopleViewModel.getPeopleList().observe(this){
            if(!it.isNullOrEmpty()){
                adapter.setPeopleList(it)
                adapter.notifyItemRangeInserted(0, it.size)
            }
            binding.peopleProgressBar.visibility = View.GONE
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
                updatePeople()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updatePeople(){
        binding.peopleProgressBar.visibility = View.VISIBLE
        val response = peopleViewModel.updatePeopleList()
        response.observe(this){
            if(!it.isNullOrEmpty()){
                adapter.setPeopleList(it)
                adapter.notifyDataSetChanged()
            }
            binding.peopleProgressBar.visibility = View.GONE
        }

    }
}