package co.paulfran.paulfranco.mynotes.framework.di

import co.paulfran.paulfranco.mynotes.framework.ListViewModel
import co.paulfran.paulfranco.mynotes.framework.NoteViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}