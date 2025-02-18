package io.github.vndevteam.applicationrunner.common

object Constants {
    const val DEFAULT_TZ = "Asia/Tokyo"
    val FIELDS_TO_REDACT = setOf("password", "token", "access_token")

    object Arguments {
        const val TASK_NAME = "task_name"
    }
}