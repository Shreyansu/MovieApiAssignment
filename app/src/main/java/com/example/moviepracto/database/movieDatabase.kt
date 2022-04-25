package com.example.moviepracto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviepracto.models.Converters
import com.example.moviepracto.models.Result

@Database(entities = [Result::class],version=1)
@TypeConverters(Converters::class)


abstract class movieDatabase :RoomDatabase()
{
    abstract fun movieDaao():movieDao
    companion object
    {
        @Volatile
        private var INSTANCE: movieDatabase? = null

        fun getDatabase(context: Context): movieDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        movieDatabase::class.java,
                        "movieDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}

