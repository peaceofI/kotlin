
package com.study.barakahfocus.domain.repository

import com.study.barakahfocus.domain.model.SessionHistory
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface SessionHistoryRepository {
    suspend fun insertSession(session: SessionHistory)
    fun getTotalDurationBetween(start: Date, end: Date): Flow<Long>
    fun getAllSessions(): Flow<List<SessionHistory>>
}
