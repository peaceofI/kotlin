
package com.study.barakahfocus.data.local.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.study.barakahfocus.data.local.dao.*
import com.study.barakahfocus.data.local.entity.*

@Database(
    entities = [
        SubjectEntity::class,
        TaskEntity::class,
        FlashcardEntity::class,
        NoteEntity::class,
        RoutineEntity::class,
        SessionHistoryEntity::class,
        RewardPointsEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun subjectDao(): SubjectDao
    abstract fun taskDao(): TaskDao
    abstract fun flashcardDao(): FlashcardDao
    abstract fun noteDao(): NoteDao
    abstract fun routineDao(): RoutineDao
    abstract fun sessionHistoryDao(): SessionHistoryDao
    abstract fun rewardPointsDao(): RewardPointsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: android.content.Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "barakah_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
