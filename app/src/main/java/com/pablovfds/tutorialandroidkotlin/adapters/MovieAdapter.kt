package com.pablovfds.tutorialandroidkotlin.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.pablovfds.tutorialandroidkotlin.data.models.Movie
import android.view.LayoutInflater
import com.pablovfds.tutorialandroidkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*


class MovieAdapter
    constructor(private val movieList: List<Movie>,
                private val context: Context): Adapter<MovieAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val movie = movieList.get(position)
        holder?.movieTitle?.setText(movie.title)
        holder?.movieYear?.setText(movie.year)

        Log.d("POSTETE", movie.poster)

        Picasso.with(context).load(movie.poster).error(R.drawable.poster_default).into(holder?.moviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = movieList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle = itemView.tv_movie_title
        val movieYear = itemView.tv_movie_year
        val moviePoster = itemView.iv_movie_poster
    }

}