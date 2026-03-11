
package com.study.barakahfocus.domain.model

import java.util.Date

data class RewardPoints(
    val points: Int = 0,
    val streakDays: Int = 0,
    val lastActivityDate: Date? = null
)
