package com.example.moviepracto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieName: TextView =findViewById(R.id.name);
        val movieImage: ImageView =findViewById(R.id.movieimage);
        val movieDetails: TextView =findViewById(R.id.details);


        val bundle: Bundle?= intent.extras
        val heading=bundle!!.getString("title")
        val details=bundle.getString("desc")

        Picasso.get()
            .load("https://www.themoviedb.org/t/p/w300_and_h450_bestv2" + intent.getStringExtra("poster_path"))
            .into(movieImage)


        movieName.text=heading
        movieDetails.text=details
    }
}