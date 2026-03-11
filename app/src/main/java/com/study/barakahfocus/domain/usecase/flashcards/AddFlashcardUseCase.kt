
package com.study.barakahfocus.domain.usecase.flashcards

import com.study.barakahfocus.domain.model.Flashcard
import com.study.barakahfocus.domain.repository.FlashcardRepository
import javax.inject.Inject

class AddFlashcardUseCase @Inject constructor(
    private val repository: FlashcardRepository
) {
    suspend operator fun invoke(flashcard: Flashcard) {
        repository.insertFlashcard(flashcard)
    }
}
