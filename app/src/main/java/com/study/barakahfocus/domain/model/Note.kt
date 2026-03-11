
package com.study.barakahfocus.domain.model

import java.util.Date

data class Note(
    val id: Long = 0,
    val title: String,
    val content: String,
    val subjectId: Long?,
    val lastModified: Date = Date()
)
