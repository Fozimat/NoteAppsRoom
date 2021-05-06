package com.fozimat.noteappsroom.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.fozimat.noteappsroom.database.Note
import com.fozimat.noteappsroom.repository.NoteRepository
import kotlinx.coroutines.InternalCoroutinesApi

class NoteAddUpdateViewModel(application: Application): ViewModel() {
    @InternalCoroutinesApi
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    @InternalCoroutinesApi
    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    @InternalCoroutinesApi
    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    @InternalCoroutinesApi
    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}