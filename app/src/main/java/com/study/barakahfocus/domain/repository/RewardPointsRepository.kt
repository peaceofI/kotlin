
package com.study.barakahfocus.domain.repository

import com.study.barakahfocus.domain.model.RewardPoints
import kotlinx.coroutines.flow.Flow

interface RewardPointsRepository {
    fun getPoints(): Flow<RewardPoints?>
    suspend fun updatePoints(points: RewardPoints)
}
