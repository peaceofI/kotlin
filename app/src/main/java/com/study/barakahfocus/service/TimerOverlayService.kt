
package com.study.barakahfocus.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TimerOverlayService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: implement overlay
        return START_STICKY
    }
}
