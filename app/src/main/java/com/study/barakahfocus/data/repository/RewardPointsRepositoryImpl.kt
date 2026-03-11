
package com.study.barakahfocus.data.repository

import com.study.barakahfocus.data.local.dao.RewardPointsDao
import com.study.barakahfocus.data.local.entity.RewardPointsEntity
import com.study.barakahfocus.domain.model.RewardPoints
import com.study.barakahfocus.domain.repository.RewardPointsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RewardPointsRepositoryImpl @Inject constructor(
    private val dao: RewardPointsDao
) : RewardPointsRepository {
    override fun getPoints(): Flow<RewardPoints?> =
        dao.getPoints().map { entity -> entity?.toDomain() }

    override suspend fun updatePoints(points: RewardPoints) {
        dao.insertOrUpdate(points.toEntity())
    }

    private fun RewardPointsEntity.toDomain(): RewardPoints = RewardPoints(
        points = points,
        streakDays = streakDays,
        lastActivityDate = lastActivityDate
    )

    private fun RewardPoints.toEntity(): RewardPointsEntity = RewardPointsEntity(
        id = 1,
        points = points,
        streakDays = streakDays,
        lastActivityDate = lastActivityDate
    )
}
