
package com.study.barakahfocus.domain.usecase.rewards

import com.study.barakahfocus.domain.model.RewardPoints
import com.study.barakahfocus.domain.repository.RewardPointsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRewardPointsUseCase @Inject constructor(
    private val repository: RewardPointsRepository
) {
    operator fun invoke(): Flow<RewardPoints?> = repository.getPoints()
}
