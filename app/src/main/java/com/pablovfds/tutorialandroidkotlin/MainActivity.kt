package com.pablovfds.tutorialandroidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pablovfds.tutorialandroidkotlin.adapters.MovieAdapter
import com.pablovfds.tutorialandroidkotlin.data.models.Movie
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMovieList = rv_movie_list
        rvMovieList.adapter = MovieAdapter(movies(), this)

        val layoutManager = LinearLayoutManager(this)
        rvMovieList.setHasFixedSize(true)
        rvMovieList.layoutManager = layoutManager
    }

    private fun movies(): List<Movie> {
        return listOf(
                Movie("Marvel 75 Years: From Pulp to Pop!",
                        "2014",
                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"),
                Movie("Marvel: Ultimate Alliance 2",
                        "2009",
                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"),
                Movie("Lego Marvel Super Heroes: Maximum Overload",
                        "2018-",
                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"))
    }
}
