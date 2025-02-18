package io.github.vndevteam.applicationrunner.common

object Constants {
    const val DEFAULT_TZ = "Asia/Tokyo"
    const val SYNC_EXECUTION_WARN_THRESHOLD_MS = 600000 // 10 minutes (10 * 60 * 1000ms)
    val FIELDS_TO_REDACT = setOf("password", "token", "access_token")

    object Arguments {
        const val TASK_NAME = "task_name"
    }
}