
package com.study.barakahfocus.domain.usecase

import com.study.barakahfocus.domain.repository.SessionHistoryRepository
import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import javax.inject.Inject

class GetTodayStudyTimeUseCase @Inject constructor(
    private val sessionHistoryRepository: SessionHistoryRepository
) {
    operator fun invoke(): Flow<Long> {
        val todayStart = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time
        val todayEnd = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.time
        return sessionHistoryRepository.getTotalDurationBetween(todayStart, todayEnd)
    }
}
