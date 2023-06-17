package com.gquesada.notes.data.repositories

import com.gquesada.notes.data.datasources.LocalNoteDataSource
import com.gquesada.notes.data.mappers.NoteMapper.toNote
import com.gquesada.notes.data.models.LocalNote
import com.gquesada.notes.data.models.LocalTag
import com.gquesada.notes.domain.models.NoteModel
import com.gquesada.notes.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val localNoteDataSource: LocalNoteDataSource
) : NoteRepository {

    override fun getAllNotes(): List<NoteModel> =
        localNoteDataSource.getAllNotes()
            .map { item -> item.toNote() }

    override fun addNote(note: NoteModel) {
        val localNote = LocalNote(note.id, note.title, note.description, LocalTag(note.tag.id, note.tag.title), note.date)
        localNoteDataSource.addNote(localNote)

    }

    override fun deleteNote(id: Int) {
        localNoteDataSource.deleteNote(id)
    }

}