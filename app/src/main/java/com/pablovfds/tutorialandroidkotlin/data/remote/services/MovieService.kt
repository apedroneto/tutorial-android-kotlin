package com.pablovfds.tutorialandroidkotlin.data.remote.services

import com.pablovfds.tutorialandroidkotlin.data.ApiContants
import com.pablovfds.tutorialandroidkotlin.data.remote.services.model.SearchMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET(ApiContants.API_SEARCh)
    fun searchMovie(@Query("s") title: String,
                    @Query("y") year: String = "",
                    @Query("page") page: Int = 1,
                    @Query("apiKey") apiKey: String = "b3fe8d53"): Call<SearchMovieResponse>
}