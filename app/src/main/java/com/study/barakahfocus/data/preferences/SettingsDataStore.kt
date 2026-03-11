
package com.study.barakahfocus.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class SettingsDataStore @Inject constructor(
    private val context: Context
) {
    private object Keys {
        val STUDY_DURATION = intPreferencesKey("study_duration")
        val SHORT_BREAK = intPreferencesKey("short_break")
        val LONG_BREAK = intPreferencesKey("long_break")
        val THEME = stringPreferencesKey("theme") // "light", "dark", "system"
        val AUDIO_ENABLED = booleanPreferencesKey("audio_enabled")
        val PRAYER_NOTIFICATIONS = booleanPreferencesKey("prayer_notifications")
        val BLOCKED_APPS = stringPreferencesKey("blocked_apps") // comma-separated
        val PIN_HASH = stringPreferencesKey("pin_hash")
    }

    val studyDuration: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[Keys.STUDY_DURATION] ?: 25
    }

    val shortBreak: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[Keys.SHORT_BREAK] ?: 5
    }

    val longBreak: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[Keys.LONG_BREAK] ?: 15
    }

    val theme: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[Keys.THEME] ?: "system"
    }

    val audioEnabled: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[Keys.AUDIO_ENABLED] ?: true
    }

    val prayerNotifications: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[Keys.PRAYER_NOTIFICATIONS] ?: true
    }

    val blockedApps: Flow<List<String>> = context.dataStore.data.map { preferences ->
        preferences[Keys.BLOCKED_APPS]?.split(",") ?: emptyList()
    }

    val pinHash: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[Keys.PIN_HASH]
    }

    suspend fun updateStudyDuration(duration: Int) {
        context.dataStore.edit { settings ->
            settings[Keys.STUDY_DURATION] = duration
        }
    }

    suspend fun updateShortBreak(breakTime: Int) {
        context.dataStore.edit { settings ->
            settings[Keys.SHORT_BREAK] = breakTime
        }
    }

    suspend fun updateLongBreak(breakTime: Int) {
        context.dataStore.edit { settings ->
            settings[Keys.LONG_BREAK] = breakTime
        }
    }

    suspend fun updateTheme(theme: String) {
        context.dataStore.edit { settings ->
            settings[Keys.THEME] = theme
        }
    }

    suspend fun setAudioEnabled(enabled: Boolean) {
        context.dataStore.edit { settings ->
            settings[Keys.AUDIO_ENABLED] = enabled
        }
    }

    suspend fun setPrayerNotifications(enabled: Boolean) {
        context.dataStore.edit { settings ->
            settings[Keys.PRAYER_NOTIFICATIONS] = enabled
        }
    }

    suspend fun setBlockedApps(apps: List<String>) {
        context.dataStore.edit { settings ->
            settings[Keys.BLOCKED_APPS] = apps.joinToString(",")
        }
    }

    suspend fun setPinHash(hash: String) {
        context.dataStore.edit { settings ->
            settings[Keys.PIN_HASH] = hash
        }
    }

    suspend fun clearPin() {
        context.dataStore.edit { settings ->
            settings.remove(Keys.PIN_HASH)
        }
    }
}
