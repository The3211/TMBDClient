package com.aiyaz.tmbdclient.data.repository.movie

import com.aiyaz.tmbdclient.data.model.movie.Movie
import com.aiyaz.tmbdclient.data.model.movie.MovieList
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieCacheDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieLocalDataSource
import com.aiyaz.tmbdclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.aiyaz.tmbdclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        return newListOfMovies
    }


    suspend fun getMoviesFromAPI(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            val response = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (exception: Exception){

        }

        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try{
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception: Exception){

        }
        if(movieList.isNotEmpty()) {
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie>{
        lateinit var movieList: List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception: Exception){

        }
        if(movieList.isNotEmpty()) {
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}