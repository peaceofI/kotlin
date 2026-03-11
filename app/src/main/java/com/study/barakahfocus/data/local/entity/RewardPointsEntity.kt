
package com.study.barakahfocus.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reward_points")
data class RewardPointsEntity(
    @PrimaryKey val id: Int = 1,
    val points: Int = 0,
    val streakDays: Int = 0,
    val lastActivityDate: Date? = null
)
