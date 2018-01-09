package com.pablovfds.tutorialandroidkotlin.data.models

import com.google.gson.annotations.SerializedName

data class Movie constructor(
        @SerializedName("Title") var title: String,
        @SerializedName("Year") var year: String,
        @SerializedName("Poster") var poster: String)