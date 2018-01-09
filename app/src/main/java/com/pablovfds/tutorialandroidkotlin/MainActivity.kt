package com.pablovfds.tutorialandroidkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pablovfds.tutorialandroidkotlin.adapters.MovieAdapter
import com.pablovfds.tutorialandroidkotlin.data.ApiContants
import com.pablovfds.tutorialandroidkotlin.data.ApiManager
import com.pablovfds.tutorialandroidkotlin.data.models.Movie
import com.pablovfds.tutorialandroidkotlin.data.remote.services.MovieService
import com.pablovfds.tutorialandroidkotlin.data.remote.services.model.SearchMovieResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvMovieList = rv_movie_list
          val layoutManager = LinearLayoutManager(this)
        rvMovieList.setHasFixedSize(true)
        rvMovieList.layoutManager = layoutManager

        val movieService: MovieService = ApiManager.createService(MovieService::class.java)

        val call: Call<SearchMovieResponse> = movieService.searchMovie("marvel")

        call.enqueue(object : Callback<SearchMovieResponse> {
            override fun onResponse(call: Call<SearchMovieResponse>?, response: Response<SearchMovieResponse>) {
                if (response.isSuccessful) {
                    rvMovieList.adapter = MovieAdapter(response.body().searchList, this@MainActivity)
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, t?.message, Toast.LENGTH_LONG).show()
            }

        })


    }

//    private fun movies(): List<Movie> {
//        return listOf(
//                Movie("Marvel 75 Years: From Pulp to Pop!",
//                        "2014",
//                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"),
//                Movie("Marvel: Ultimate Alliance 2",
//                        "2009",
//                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"),
//                Movie("Lego Marvel Super Heroes: Maximum Overload",
//                        "2018-",
//                        "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MjE1NTk3NF5BMl5BanBnXkFtZTgwMTk4Mjg2NDE@._V1_SX300.jpg"))
//    }
}
