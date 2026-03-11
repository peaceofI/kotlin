
package com.study.barakahfocus.domain.usecase.notes

import com.study.barakahfocus.domain.model.Note
import com.study.barakahfocus.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.insertNote(note)
    }
}
