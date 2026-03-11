
package com.study.barakahfocus.domain.usecase.flashcards

import com.study.barakahfocus.domain.model.Flashcard
import com.study.barakahfocus.domain.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date
import javax.inject.Inject

class GetDueFlashcardsUseCase @Inject constructor(
    private val repository: FlashcardRepository
) {
    operator fun invoke(now: Date = Date()): Flow<List<Flashcard>> =
        repository.getDueFlashcards(now)
}
