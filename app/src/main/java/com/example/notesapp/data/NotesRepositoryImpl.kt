package com.example.notesapp.data

import com.example.notesapp.domain.NoteRepository
import com.example.notesapp.domain.UserNote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotesRepositoryImpl(
    private val dao: NotesDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<UserNote>> {
        return dao.getAllNotes().map { notes ->
            notes.map { note ->
                val sdf = SimpleDateFormat("MMM dd yyyy", Locale.getDefault())
                val formattedDate = sdf.format(Date(note.time))
                UserNote(note.id, note.title, note.description, formattedDate)
            }
        }
    }

    override suspend fun addNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {

    }

}