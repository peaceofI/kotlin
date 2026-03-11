
package com.study.barakahfocus.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "flashcards")
data class FlashcardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val question: String,
    val answer: String,
    val subjectId: Long,
    var easeFactor: Double = 2.5,
    var interval: Int = 0,
    var nextReviewDate: Date = Date()
)
