package com.aiyaz.tmbdclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aiyaz.tmbdclient.R
import com.aiyaz.tmbdclient.databinding.ActivityHomeBinding
import com.aiyaz.tmbdclient.presentation.movie.MovieActivity
import com.aiyaz.tmbdclient.presentation.people.PeopleActivity
import com.aiyaz.tmbdclient.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        activityHomeBinding.buttonMovies.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }


        activityHomeBinding.buttonTvshow.setOnClickListener{
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        activityHomeBinding.buttonPeopls.setOnClickListener {
            val intent = Intent(this, PeopleActivity::class.java)
            startActivity(intent)
        }
    }
}