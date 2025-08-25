package com.example.notesapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotesApp : Application() {

    override fun onCreate() {
        //This is my Change From PersonB in BranchB
        super.onCreate()
        //My Message
    }
}