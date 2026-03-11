
package com.study.barakahfocus.domain.model

import java.util.Date

data class SessionHistory(
    val id: Long = 0,
    val subjectId: Long?,
    val startTime: Date,
    val endTime: Date,
    val duration: Long // minutes
)
