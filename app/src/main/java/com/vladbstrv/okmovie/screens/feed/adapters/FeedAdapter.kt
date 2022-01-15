package com.vladbstrv.okmovie.screens.feed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.model.Movie

class FeedAdapter : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    private val mMovieList: MutableList<Movie> = ArrayList()

    fun setData(newMovie: List<Movie>) {
        mMovieList.clear()
        mMovieList.addAll(newMovie)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_feeds, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mMovieList[position])
    }

    override fun getItemCount(): Int {
        return mMovieList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPoster: ImageView = itemView.findViewById(R.id.imgPosterItem)
        private val titleItem: TextView = itemView.findViewById(R.id.titleItem)
        private val genreItem: TextView = itemView.findViewById(R.id.genreItem)

        fun bind(model: Movie) {
//            imgPoster.setImageResource(model.poster)
            titleItem.text = model.title
            genreItem.text = model.genre
        }
    }
}