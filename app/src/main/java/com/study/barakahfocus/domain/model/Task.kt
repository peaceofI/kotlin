
package com.study.barakahfocus.domain.model

import java.util.Date

data class Task(
    val id: Long = 0,
    val title: String,
    val description: String?,
    val subjectId: Long,
    val deadline: Date?,
    val priority: Int,
    val estimatedTime: Int,
    val isCompleted: Boolean = false
)
