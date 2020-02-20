package co.paulfran.paulfranco.mynotes.framework.di

import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.core.useCase.*
import co.paulfran.paulfranco.mynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}