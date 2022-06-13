package com.aiyaz.tmbdclient.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aiyaz.tmbdclient.data.model.movie.Movie
import com.aiyaz.tmbdclient.data.model.people.People
import com.aiyaz.tmbdclient.data.model.tvshow.TVShow

@Database(entities = [Movie::class,People::class,TVShow::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvDao(): TvShowDao

    abstract fun peopleDao(): PeopleDao

}