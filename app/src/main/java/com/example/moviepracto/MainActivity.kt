package com.example.moviepracto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviepracto.api.MovieService
import com.example.moviepracto.api.RetrofitHelper
import com.example.moviepracto.models.Result
import com.example.moviepracto.repository.MovieRepository
import com.example.moviepracto.viewModel.MainViewModel
import com.example.moviepracto.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity()
{
    lateinit var mainViewModel: MainViewModel

    private lateinit var newRecylerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newRecylerView=findViewById(R.id.recyclerView);
        newRecylerView.layoutManager= LinearLayoutManager(this);
        newRecylerView.setHasFixedSize(true);
        loadMovies()

    }

    private fun loadMovies()
    {
        val repository = (application as MovieApplication).movieRepository
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)


        mainViewModel.movies.observe(this,{
            Log.e("Running",it.results.toString())

            var myadapter=movieAdapater(it.results as ArrayList<Result>)
            newRecylerView.adapter=myadapter

            myadapter.setOnItemClickListener(object : movieAdapater.onItemClickListener{

                override fun onItemClick(position: Int) {


                    val list=it.results[position]
                    val intent =
                        Intent(this@MainActivity, MovieDetailActivity::class.java)
                    intent.putExtra("title", list.title)
                    intent.putExtra("desc", list.overview)
                    intent.putExtra("poster_path", list.poster_path)
                    intent.putExtra("date",list.release_date)

                    startActivity(intent)
                }
            })

        })






    }

}