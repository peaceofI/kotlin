
package com.study.barakahfocus.di

import android.content.Context
import androidx.room.Room
import com.study.barakahfocus.data.local.dao.*
import com.study.barakahfocus.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "barakah_database"
        ).build()
    }

    @Provides
    fun provideSubjectDao(database: AppDatabase): SubjectDao = database.subjectDao()

    @Provides
    fun provideTaskDao(database: AppDatabase): TaskDao = database.taskDao()

    @Provides
    fun provideFlashcardDao(database: AppDatabase): FlashcardDao = database.flashcardDao()

    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao = database.noteDao()

    @Provides
    fun provideRoutineDao(database: AppDatabase): RoutineDao = database.routineDao()

    @Provides
    fun provideSessionHistoryDao(database: AppDatabase): SessionHistoryDao = database.sessionHistoryDao()

    @Provides
    fun provideRewardPointsDao(database: AppDatabase): RewardPointsDao = database.rewardPointsDao()
}
