package com.example.notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}