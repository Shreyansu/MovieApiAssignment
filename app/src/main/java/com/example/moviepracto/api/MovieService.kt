package com.example.moviepracto.api

import com.example.moviepracto.models.MovieList
import retrofit2.Response
import retrofit2.http.GET

interface MovieService
{
    @GET("popular?api_key=e0aaddc67800088a40594b3724ccbb89")
    suspend fun getMovies():Response<MovieList>
}