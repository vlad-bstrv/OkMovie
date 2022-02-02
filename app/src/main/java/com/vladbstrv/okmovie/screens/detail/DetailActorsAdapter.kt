package com.vladbstrv.okmovie.screens.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vladbstrv.okmovie.R
import com.vladbstrv.okmovie.model.Genre
import com.vladbstrv.okmovie.model.data.entities.rest_entities.Persons
import com.vladbstrv.okmovie.screens.feed.adapters.GenresAdapter
import org.w3c.dom.Text

class DetailActorsAdapter : RecyclerView.Adapter<DetailActorsAdapter.ViewHolder>() {

    private val mActorsList: MutableList<Persons> = ArrayList()

    fun setData(newActors: List<Persons>) {
        mActorsList.clear()
        mActorsList.addAll(newActors)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_details_actors, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mActorsList[position])
    }

    override fun getItemCount(): Int {
        return mActorsList.count()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster: ImageView = itemView.findViewById(R.id.photo)
        private val name: TextView = itemView.findViewById(R.id.name)
        private val profession: TextView = itemView.findViewById(R.id.profession)

        fun bind(actor: Persons) {
            Glide.with(itemView).load(actor.photo).into(poster)
            name.text = actor.name
            profession.text = actor.enProfession
        }
    }

}