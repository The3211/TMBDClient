package com.aiyaz.tmbdclient.data.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aiyaz.tmbdclient.data.model.people.People

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePeoples(peoples: List<People>)

    @Query("delete from popular_people")
    suspend fun deleteAllPeopleData()

    @Query("select * from popular_people")
    suspend fun getAllPeopleData(): List<People>
}