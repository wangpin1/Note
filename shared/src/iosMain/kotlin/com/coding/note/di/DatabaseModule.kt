package com.coding.note.di

import com.coding.note.data.local.DatabaseDriverFactory
import com.coding.note.data.note.SqlDelightNoteDataSource
import com.coding.note.database.NoteDatabase
import com.coding.note.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}