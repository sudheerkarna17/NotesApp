package com.example.notesapp.domain

data class UserNote(
    val id: Int = 0,
    val title: String,
    val description: String,
    val time: String
)
