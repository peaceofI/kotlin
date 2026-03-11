
package com.study.barakahfocus.domain.usecase.rewards

import com.study.barakahfocus.domain.model.RewardPoints
import com.study.barakahfocus.domain.repository.RewardPointsRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AddPointsUseCase @Inject constructor(
    private val repository: RewardPointsRepository
) {
    suspend operator fun invoke(pointsToAdd: Int) {
        val current = repository.getPoints().first() ?: RewardPoints()
        val updated = current.copy(points = current.points + pointsToAdd)
        repository.updatePoints(updated)
    }
}
