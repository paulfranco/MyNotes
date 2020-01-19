package co.paulfran.paulfranco.core.useCase

import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteRepository

class AddNote(private val noteRespository: NoteRepository) {

    suspend operator fun invoke(note: Note) = noteRespository.addNote(note)
}

