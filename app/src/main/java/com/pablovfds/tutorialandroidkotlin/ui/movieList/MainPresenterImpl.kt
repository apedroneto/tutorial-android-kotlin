package com.pablovfds.tutorialandroidkotlin.ui.movieList

import com.pablovfds.tutorialandroidkotlin.data.models.Movie

class MainPresenterImpl
    constructor(private var mMainModel: MainContract.Model) : MainContract.Presenter, MainContract.Model.MainListener{

    private var mMainView: MainContract.View? = null

    override fun attachView(view: MainContract.View) {
        mMainView = view
    }

    override fun detachView() {
        mMainView = null
    }

    override fun onFailure(error: String) {
        mMainView?.showError(error)
    }

    override fun onSuccess(movies: List<Movie>) {
        mMainView?.setMovies(movies)
    }

    override fun loadMovies(title: String, year: String, page: Int, apiKey: String) {
        mMainModel.loadMovies(title, year, page, apiKey, this)
    }
}