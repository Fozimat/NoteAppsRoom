package com.fozimat.noteappsroom.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fozimat.noteappsroom.database.Note
import com.fozimat.noteappsroom.repository.NoteRepository
import kotlinx.coroutines.InternalCoroutinesApi

class MainViewModel(application: Application): ViewModel() {
    @InternalCoroutinesApi
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    @InternalCoroutinesApi
    fun getAllNotes(): LiveData<PagedList<Note>> = LivePagedListBuilder(mNoteRepository.getAllNotes(), 20).build()
}