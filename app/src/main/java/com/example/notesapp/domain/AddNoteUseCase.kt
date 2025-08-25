package com.example.notesapp.domain

import com.example.notesapp.data.Note

class AddNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) = repository.addNote(note)

}