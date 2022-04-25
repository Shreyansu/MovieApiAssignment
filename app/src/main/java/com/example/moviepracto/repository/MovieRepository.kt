package com.example.moviepracto.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviepracto.api.MovieService
import com.example.moviepracto.database.movieDatabase
import com.example.moviepracto.models.MovieList

class MovieRepository(private val movieService : MovieService,private val moviedatabase:movieDatabase)
{
    private val moviesLiveData=MutableLiveData<MovieList>()

    val movies: LiveData<MovieList>
    get() = moviesLiveData
    suspend fun getMovies()
    {
        val result=movieService.getMovies()
        if(result?.body()!=null)
        {
            moviedatabase.movieDaao().addmovie(result.body()!!.results)
            moviesLiveData.postValue((result.body()));
        }
    }

}