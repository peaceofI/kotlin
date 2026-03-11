
package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.study.barakahfocus.data.local.entity.SessionHistoryEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface SessionHistoryDao {
    @Insert
    suspend fun insert(session: SessionHistoryEntity)

    @Query("SELECT SUM(duration) FROM session_history WHERE startTime BETWEEN :start AND :end")
    fun getTotalDurationBetween(start: Date, end: Date): Flow<Long>

    @Query("SELECT * FROM session_history ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<SessionHistoryEntity>>
}
