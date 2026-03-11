
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.FlashcardDao
import com.study.barakahfocus.data.local.entity.FlashcardEntity
import com.study.barakahfocus.domain.model.Flashcard
import com.study.barakahfocus.domain.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlashcardRepositoryImpl @Inject constructor(
    private val dao: FlashcardDao
) : FlashcardRepository {
    override fun getAllFlashcards(): Flow<List<Flashcard>> =
        dao.getAllFlashcards().map { entities -> entities.map { it.toDomain() } }

    override fun getDueFlashcards(now: Date): Flow<List<Flashcard>> =
        dao.getDueFlashcards(now).map { entities -> entities.map { it.toDomain() } }

    override suspend fun insertFlashcard(flashcard: Flashcard) {
        dao.insert(flashcard.toEntity())
    }

    override suspend fun updateFlashcard(flashcard: Flashcard) {
        dao.update(flashcard.toEntity())
    }

    override suspend fun deleteFlashcard(id: Long) {
        dao.deleteById(id)
    }

    private fun FlashcardEntity.toDomain(): Flashcard = Flashcard(
        id = id,
        question = question,
        answer = answer,
        subjectId = subjectId,
        easeFactor = easeFactor,
        interval = interval,
        nextReviewDate = nextReviewDate
    )

    private fun Flashcard.toEntity(): FlashcardEntity = FlashcardEntity(
        id = id,
        question = question,
        answer = answer,
        subjectId = subjectId,
        easeFactor = easeFactor,
        interval = interval,
        nextReviewDate = nextReviewDate
    )
}
