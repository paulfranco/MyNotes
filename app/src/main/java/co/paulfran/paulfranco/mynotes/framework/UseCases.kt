package co.paulfran.paulfranco.mynotes.framework

import co.paulfran.paulfranco.core.useCase.AddNote
import co.paulfran.paulfranco.core.useCase.GetAllNotes
import co.paulfran.paulfranco.core.useCase.GetNote
import co.paulfran.paulfranco.core.useCase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
    )
