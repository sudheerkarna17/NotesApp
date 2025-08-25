package com.example.notesapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.NotesApp
import com.example.notesapp.databinding.ActivityNotesBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding

    private lateinit var adapter: NotesAdapter

    private val viewmodel: NotesListViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set Adapter
        adapter = NotesAdapter()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        //Collect Notes
        lifecycleScope.launch {
            viewmodel.notes.collectLatest { notesList ->
                adapter.addNotes(
                    notes = notesList
                )
            }
        }

        //Add Notes
        binding.addNotesIcon.setOnClickListener {
            val intent = Intent(this, AddNoteFragment::class.java)
            startActivity(intent)
        }

    }

}