package com.fozimat.noteappsroom.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fozimat.noteappsroom.database.Note
import com.fozimat.noteappsroom.repository.NoteRepository
import kotlinx.coroutines.InternalCoroutinesApi

class MainViewModel(application: Application): ViewModel() {
    @InternalCoroutinesApi
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    @InternalCoroutinesApi
    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}