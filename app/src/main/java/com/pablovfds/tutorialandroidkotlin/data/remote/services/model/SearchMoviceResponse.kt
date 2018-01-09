package com.pablovfds.tutorialandroidkotlin.data.remote.services.model

import com.pablovfds.tutorialandroidkotlin.data.models.Movie
import com.google.gson.annotations.SerializedName

data class SearchMovieResponse (
        @SerializedName("Search")
        val searchList: List<Movie>,

        @SerializedName("Response")
        val response: String
)