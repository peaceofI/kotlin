
package com.study.barakahfocus.domain.model

data class Routine(
    val id: Long = 0,
    val name: String,
    val startTime: String, // "HH:mm"
    val daysOfWeek: String // comma separated, 1=Mon..7=Sun
)
