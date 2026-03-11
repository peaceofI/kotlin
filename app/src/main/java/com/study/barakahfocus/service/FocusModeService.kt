
package com.study.barakahfocus.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class FocusModeService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: monitor foreground apps
        return START_STICKY
    }
}
