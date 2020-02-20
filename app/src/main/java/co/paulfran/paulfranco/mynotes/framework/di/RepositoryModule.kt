package co.paulfran.paulfranco.mynotes.framework.di

import android.app.Application
import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.mynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))

}