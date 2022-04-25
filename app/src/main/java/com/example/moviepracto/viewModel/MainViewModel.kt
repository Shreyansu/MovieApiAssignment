package com.example.moviepracto.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviepracto.models.MovieList
import com.example.moviepracto.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MovieRepository) : ViewModel()
{
    init {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getMovies()
        }
    }

    val movies: LiveData<MovieList>
    get()=repository.movies
}