package com.example.notesapp.domain

import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke() = repository.getAllNotes()
}