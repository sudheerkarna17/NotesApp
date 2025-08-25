package com.example.notesapp.domain

import com.example.notesapp.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<List<UserNote>>
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}