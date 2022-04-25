package com.example.moviepracto

import android.app.Application
import com.example.moviepracto.api.MovieService
import com.example.moviepracto.api.RetrofitHelper
import com.example.moviepracto.database.movieDatabase
import com.example.moviepracto.repository.MovieRepository

class MovieApplication :Application()
{
    lateinit var movieRepository:MovieRepository
    override fun onCreate() {
        super.onCreate()
        initialize();

    }

    private fun initialize() {
        val movieService = RetrofitHelper.getRetrofitInstance().create(MovieService::class.java)
        val database=movieDatabase.getDatabase(applicationContext)
        movieRepository=MovieRepository(movieService,database)
    }
}