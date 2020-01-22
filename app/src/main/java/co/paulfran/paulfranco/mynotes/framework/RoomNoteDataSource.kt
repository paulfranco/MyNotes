package co.paulfran.paulfranco.mynotes.framework

import android.content.Context
import co.paulfran.paulfranco.core.data.Note
import co.paulfran.paulfranco.core.repository.NoteDataSource
import co.paulfran.paulfranco.mynotes.framework.db.DatabaseService
import co.paulfran.paulfranco.mynotes.framework.db.NoteEntity

class RoomNoteDataSource(context: Context): NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}