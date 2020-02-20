package co.paulfran.paulfranco.mynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteRepository
import co.paulfran.paulfranco.core.useCase.AddNote
import co.paulfran.paulfranco.core.useCase.GetAllNotes
import co.paulfran.paulfranco.core.useCase.GetNote
import co.paulfran.paulfranco.core.useCase.RemoveNote
import co.paulfran.paulfranco.mynotes.framework.di.ApplicationModule
import co.paulfran.paulfranco.mynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach{ it.wordCount = useCases.getWordCount.invoke(it)}
            notes.postValue(noteList)
        }
    }


}