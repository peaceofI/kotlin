
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.SessionHistoryDao
import com.study.barakahfocus.data.local.entity.SessionHistoryEntity
import com.study.barakahfocus.domain.model.SessionHistory
import com.study.barakahfocus.domain.repository.SessionHistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionHistoryRepositoryImpl @Inject constructor(
    private val dao: SessionHistoryDao
) : SessionHistoryRepository {
    override suspend fun insertSession(session: SessionHistory) {
        dao.insert(session.toEntity())
    }

    override fun getTotalDurationBetween(start: Date, end: Date): Flow<Long> =
        dao.getTotalDurationBetween(start, end)

    override fun getAllSessions(): Flow<List<SessionHistory>> =
        dao.getAllSessions().map { entities -> entities.map { it.toDomain() } }

    private fun SessionHistoryEntity.toDomain(): SessionHistory = SessionHistory(
        id = id,
        subjectId = subjectId,
        startTime = startTime,
        endTime = endTime,
        duration = duration
    )

    private fun SessionHistory.toEntity(): SessionHistoryEntity = SessionHistoryEntity(
        id = id,
        subjectId = subjectId,
        startTime = startTime,
        endTime = endTime,
        duration = duration
    )
}
