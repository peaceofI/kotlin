
package com.study.barakahfocus.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.barakahfocus.data.local.entity.RewardPointsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RewardPointsDao {
    @Query("SELECT * FROM reward_points WHERE id = 1")
    fun getPoints(): Flow<RewardPointsEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(points: RewardPointsEntity)
}
