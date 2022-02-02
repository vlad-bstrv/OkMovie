package com.vladbstrv.okmovie.screens.feed.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.model.data.entities.rest_entities.Docs
import com.vladbstrv.okmovie.screens.feed.FeedFragment

class FeedAdapter(
    private val onItemViewClickListener:
    FeedFragment.OnItemViewClickListener
) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    private val mMovieList: MutableList<Docs> = ArrayList()

    fun setData(newMovie: List<Docs>) {
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgPoster: ImageView = itemView.findViewById(R.id.imgPosterItem)
        private val titleItem: TextView = itemView.findViewById(R.id.titleItem)
        private val ratingKpItem: TextView = itemView.findViewById(R.id.rating_KP)
        private val ratingImdbItem: TextView = itemView.findViewById(R.id.rating_IMDB)

        fun bind(model: Docs) {
            titleItem.text = model.name
            ratingKpItem.text = model.rating.kp.toString()
            ratingImdbItem.text = model.rating.imdb.toString()

            Glide.with(itemView).load(model.poster.previewUrl).into(imgPoster)

            itemView.setOnClickListener {
                onItemViewClickListener.OnItemViewClick(model)
            }
        }
    }
}