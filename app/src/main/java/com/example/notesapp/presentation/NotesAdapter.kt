package com.example.notesapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.NoteItemLayoutBinding
import com.example.notesapp.domain.UserNote

class NotesAdapter(
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private val notesList = mutableListOf<UserNote>()


    fun addNotes(notes: List<UserNote>) {
        notesList.clear()
        notesList.addAll(notes)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = NoteItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        val note: UserNote = notesList[position]

        //Title
        holder.binding.titleTv.text = note.title
        //Description
        holder.binding.descriptionTv.text = note.description
        //Date
        holder.binding.dateTv.text = note.time

    }

    override fun getItemCount(): Int {
        return notesList.size
    }


    inner class ViewHolder(val binding: NoteItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


}