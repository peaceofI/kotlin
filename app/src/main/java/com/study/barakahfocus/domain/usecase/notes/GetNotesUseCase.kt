
package com.study.barakahfocus.domain.usecase.notes

import com.study.barakahfocus.domain.model.Note
import com.study.barakahfocus.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> = repository.getAllNotes()
}
