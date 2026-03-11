
package com.study.barakahfocus.domain.model

import java.util.Date

data class Flashcard(
    val id: Long = 0,
    val question: String,
    val answer: String,
    val subjectId: Long,
    val easeFactor: Double = 2.5,
    val interval: Int = 0,
    val nextReviewDate: Date = Date()
)
