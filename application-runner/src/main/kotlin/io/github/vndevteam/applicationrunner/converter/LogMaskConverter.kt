package io.github.vndevteam.applicationrunner.converter

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.CompositeConverter
import io.github.vndevteam.applicationrunner.common.Constants.FIELDS_TO_REDACT

class LogMaskConverter : CompositeConverter<ILoggingEvent>() {
    companion object {
        private val regex = Regex(FIELDS_TO_REDACT.joinToString("|") { "\"$it\"\\s*:\\s*\"[^\"]+\"" })
    }

    override fun transform(
        event: ILoggingEvent?,
        input: String?,
    ): String =
        input
            ?.let {
                regex.replace(it) { matchResult ->
                    val keyValue = matchResult.value
                    val key = keyValue.substringBefore(":")
                    "$key:\"*****\""
                }
            }.orEmpty()
}