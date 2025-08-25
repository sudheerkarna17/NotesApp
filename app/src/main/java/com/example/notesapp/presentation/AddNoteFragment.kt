package com.example.notesapp.presentation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.notesapp.NotesApp
import com.example.notesapp.databinding.ActivityAddNoteBinding

class AddNoteFragment : Fragment() {

    private lateinit var binding: ActivityAddNoteBinding


    private val viewModel: AddNotesViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.addNotes.setOnClickListener {

            //Checking Title or Description Empty or Not
            if (!checkFields()) {
                return@setOnClickListener
            }

            viewModel.addNote(
                title = binding.titleEt.text.toString(),
                description = binding.descriptionEt.text.toString()
            )
            parentFragmentManager.popBackStack()
        }

        //Back
        binding.backActionIcon.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun checkFields(): Boolean {

        if (binding.titleEt.text.toString().trim().isEmpty()) {

            Toast.makeText(requireContext(), "Please enter title", Toast.LENGTH_SHORT)
                .show()
            return false

        } else if (binding.descriptionEt.text.toString().trim().isEmpty()) {

            Toast.makeText(requireContext(), "Please enter description", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }

}