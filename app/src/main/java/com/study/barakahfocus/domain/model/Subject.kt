
package com.study.barakahfocus.domain.model

data class Subject(
    val id: Long = 0,
    val name: String,
    val color: Int,
    val dailyGoalMinutes: Int,
    val totalStudyTime: Long
)
