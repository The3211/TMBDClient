package com.aiyaz.tmbdclient.data.api

import com.aiyaz.tmbdclient.data.model.movie.MovieList
import com.aiyaz.tmbdclient.data.model.people.PeopleList
import com.aiyaz.tmbdclient.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShow(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<PeopleList>

}