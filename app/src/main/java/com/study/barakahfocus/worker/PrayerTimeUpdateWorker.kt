
package com.study.barakahfocus.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class PrayerTimeUpdateWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        // TODO: calculate prayer times
        return Result.success()
    }
}
