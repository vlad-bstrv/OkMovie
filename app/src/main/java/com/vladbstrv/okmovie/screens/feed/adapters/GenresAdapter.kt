package com.vladbstrv.okmovie.screens.feed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.model.Movie

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.ViewHolder>() {

    private val mMovieList: MutableList<String> = ArrayList()

    fun setData(newMovie: List<String>) {
        mMovieList.clear()
        mMovieList.addAll(newMovie)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_feeds_genres, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mMovieList[position])
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreItem: TextView = itemView.findViewById(R.id.itemGenres)

        fun bind(model: String) {
            genreItem.text = model
        }
    }
}