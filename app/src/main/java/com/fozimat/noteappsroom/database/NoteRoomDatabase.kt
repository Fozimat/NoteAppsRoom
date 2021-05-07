package com.fozimat.noteappsroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.util.concurrent.Executors

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        @InternalCoroutinesApi
        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase {
            if (INSTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database"
                    )
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                add()
                            }
                        })
                        .build()
                }
            }
            return INSTANCE as NoteRoomDatabase
        }

        private fun add() {
            Executors.newSingleThreadExecutor().execute {
                val list: MutableList<Note> = ArrayList()
                for (i in 0..99) {
                    val dummyNote = Note()
                    dummyNote.title = "Tugas $i"
                    dummyNote.description = "Belajar Modul $i"
                    dummyNote.date = "2021/05/07 09:09:0$i"
                    list.add(dummyNote)
                }
                INSTANCE?.noteDao()?.insertAll(list)
            }
        }
    }
}