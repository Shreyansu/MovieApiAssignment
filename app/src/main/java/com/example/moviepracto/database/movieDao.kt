package com.example.moviepracto.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviepracto.models.Result
import retrofit2.http.GET

@Dao
interface movieDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addmovie(movies:List<Result>)

    @Query("SELECT * from movie")
    suspend fun getMovies(): List<Result>
}