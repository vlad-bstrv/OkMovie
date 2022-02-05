package com.vladbstrv.okmovie.screens.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.okmovie.R

import com.vladbstrv.okmovie.model.database.model.NoteModel

class NoteAdapter(
    private val onItemViewClickListener: DetailFragment.OnItemViewClickListener
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val mNoteList: MutableList<NoteModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<NoteModel>) {
        mNoteList.clear()
        mNoteList.addAll(list)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mNoteList[position])
    }

    override fun getItemCount(): Int {
        return mNoteList.count()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val note: TextView = itemView.findViewById(R.id.tv_note)
        private val delete: ImageView = itemView.findViewById(R.id.iv_delete_note)

        fun bind(noteModel: NoteModel) {
            note.text = noteModel.title
            delete.setOnClickListener {
                onItemViewClickListener.OnItemViewClick(noteModel)
            }
        }
    }
}
