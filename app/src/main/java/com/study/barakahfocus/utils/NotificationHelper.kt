
package com.study.barakahfocus.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationHelper {
    const val CHANNEL_ID_TIMER = "timer_channel"
    const val CHANNEL_ID_ROUTINE = "routine_channel"
    const val CHANNEL_ID_PRAYER = "prayer_channel"
    const val CHANNEL_ID_FLASHCARD = "flashcard_channel"
    const val CHANNEL_ID_FOCUS = "focus_channel"

    fun createChannels(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val timerChannel = NotificationChannel(
                CHANNEL_ID_TIMER,
                "Timer",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Pomodoro session finished"
                enableVibration(true)
            }
            manager.createNotificationChannel(timerChannel)

            val routineChannel = NotificationChannel(
                CHANNEL_ID_ROUTINE,
                "Routine",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Routine reminders"
                enableVibration(true)
            }
            manager.createNotificationChannel(routineChannel)

            val prayerChannel = NotificationChannel(
                CHANNEL_ID_PRAYER,
                "Prayer Times",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Prayer notifications"
                enableVibration(true)
            }
            manager.createNotificationChannel(prayerChannel)

            val flashcardChannel = NotificationChannel(
                CHANNEL_ID_FLASHCARD,
                "Flashcards",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Flashcards due for review"
                enableVibration(true)
            }
            manager.createNotificationChannel(flashcardChannel)

            val focusChannel = NotificationChannel(
                CHANNEL_ID_FOCUS,
                "Focus Mode",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Focus mode violations"
                enableVibration(true)
            }
            manager.createNotificationChannel(focusChannel)
        }
    }
}
