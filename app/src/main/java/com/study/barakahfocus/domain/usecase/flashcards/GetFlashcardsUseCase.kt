
package com.study.barakahfocus.domain.usecase.flashcards

import com.study.barakahfocus.domain.model.Flashcard
import com.study.barakahfocus.domain.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFlashcardsUseCase @Inject constructor(
    private val repository: FlashcardRepository
) {
    operator fun invoke(): Flow<List<Flashcard>> = repository.getAllFlashcards()
}
