package com.pablovfds.tutorialandroidkotlin.ui.movieList

import com.pablovfds.tutorialandroidkotlin.data.ApiManager
import com.pablovfds.tutorialandroidkotlin.data.remote.services.MovieService
import com.pablovfds.tutorialandroidkotlin.data.remote.services.model.SearchMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainModelImpl : MainContract.Model {

    private val movieService: MovieService = ApiManager.createService(MovieService::class.java)

    override fun loadMovies(title: String, year: String, page: Int, apiKey: String, listener: MainContract.Model.MainListener) {
        val call: Call<SearchMovieResponse> = movieService.searchMovie(title, year, page, apiKey)

        call.enqueue(object : Callback<SearchMovieResponse> {
            override fun onResponse(call: Call<SearchMovieResponse>?, response: Response<SearchMovieResponse>) {
                if (response.isSuccessful) {
                    listener.onSuccess(response.body().searchList)
                }
            }

            override fun onFailure(call: Call<SearchMovieResponse>?, t: Throwable?) {
                listener.onFailure(t!!.message!!)
            }

        })
    }
}