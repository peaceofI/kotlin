
package com.study.barakahfocus.domain.repository

import com.study.barakahfocus.domain.model.Flashcard
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface FlashcardRepository {
    fun getAllFlashcards(): Flow<List<Flashcard>>
    fun getDueFlashcards(now: Date): Flow<List<Flashcard>>
    suspend fun insertFlashcard(flashcard: Flashcard)
    suspend fun updateFlashcard(flashcard: Flashcard)
    suspend fun deleteFlashcard(id: Long)
}
