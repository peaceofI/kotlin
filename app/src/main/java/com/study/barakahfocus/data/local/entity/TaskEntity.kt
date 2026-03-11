
package com.study.barakahfocus.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val subjectId: Long,
    val deadline: Date?,
    val priority: Int,
    val estimatedTime: Int,
    var isCompleted: Boolean = false
)
