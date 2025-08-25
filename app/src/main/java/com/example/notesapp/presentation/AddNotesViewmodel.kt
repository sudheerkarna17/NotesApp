package com.example.notesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.domain.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNotesViewmodel @Inject constructor(
    private val addNotesUseCase: AddNoteUseCase
) : ViewModel() {


    fun addNote(title: String, description: String) {

        viewModelScope.launch(Dispatchers.IO) {
            addNotesUseCase.invoke(
                Note(
                    title = title,
                    description = description,
                    time = System.currentTimeMillis()
                )
            )
        }

    }
}