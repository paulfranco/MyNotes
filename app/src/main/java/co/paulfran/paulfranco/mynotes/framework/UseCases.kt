package co.paulfran.paulfranco.mynotes.framework

import co.paulfran.paulfranco.core.useCase.*

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWordCount: GetWordCount
    )
