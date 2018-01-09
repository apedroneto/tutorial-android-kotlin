package com.pablovfds.tutorialandroidkotlin.ui.movieList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pablovfds.tutorialandroidkotlin.R
import com.pablovfds.tutorialandroidkotlin.adapters.MovieAdapter
import com.pablovfds.tutorialandroidkotlin.data.models.Movie
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mMainPresenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMainPresenter = MainPresenterImpl(MainModelImpl())
    }

    override fun onStart() {
        super.onStart()
        mMainPresenter.attachView(this)
        mMainPresenter.loadMovies("marvel")
    }

    override fun onStop() {
        super.onStop()
        mMainPresenter.detachView()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun setMovies(movies: List<Movie>) {
        val rvMovieList = rv_movie_list
        val layoutManager = LinearLayoutManager(this)
        rvMovieList.setHasFixedSize(true)
        rvMovieList.layoutManager = layoutManager

        rvMovieList.adapter = MovieAdapter(movies, this)
    }
}
