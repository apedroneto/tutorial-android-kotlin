package com.pablovfds.tutorialandroidkotlin.ui.movieList

import com.pablovfds.tutorialandroidkotlin.data.models.Movie

interface MainContract {

    interface Model {
        interface MainListener {
            fun onFailure(error: String)
            fun onSuccess(movies: List<Movie>)
        }

        fun loadMovies(title: String,
                       year: String = "",
                       page: Int = 1,
                       apiKey: String = "b3fe8d53",
                       listener: Model.MainListener)
    }

    interface Presenter {
        fun attachView(view: View)
        fun detachView()
        fun loadMovies(title: String,
                       year: String = "",
                       page: Int = 1,
                       apiKey: String = "b3fe8d53")
    }

    interface View {
        fun setMovies(movies: List<Movie>)
        fun showError(error: String)
    }
}