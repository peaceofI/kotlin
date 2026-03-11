
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.NoteDao
import com.study.barakahfocus.data.local.entity.NoteEntity
import com.study.barakahfocus.domain.model.Note
import com.study.barakahfocus.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> =
        dao.getAllNotes().map { entities -> entities.map { it.toDomain() } }

    override fun getNotesForSubject(subjectId: Long): Flow<List<Note>> =
        dao.getNotesForSubject(subjectId).map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertNote(note: Note) {
        dao.insert(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.update(note.toEntity())
    }

    override suspend fun deleteNote(id: Long) {
        dao.deleteById(id)
    }

    private fun NoteEntity.toDomain(): Note = Note(
        id = id,
        title = title,
        content = content,
        subjectId = subjectId,
        lastModified = lastModified
    )

    private fun Note.toEntity(): NoteEntity = NoteEntity(
        id = id,
        title = title,
        content = content,
        subjectId = subjectId,
        lastModified = lastModified
    )
}
