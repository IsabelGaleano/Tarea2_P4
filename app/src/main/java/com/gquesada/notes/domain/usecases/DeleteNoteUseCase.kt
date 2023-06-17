package com.gquesada.notes.domain.usecases

import com.gquesada.notes.domain.models.NoteModel
import com.gquesada.notes.domain.repositories.NoteRepository

class DeleteNoteUseCase (private val noteRepository: NoteRepository) {

    fun execute(id: Int) = noteRepository.deleteNote(id)
}