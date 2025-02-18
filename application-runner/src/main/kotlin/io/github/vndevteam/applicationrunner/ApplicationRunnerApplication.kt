package io.github.vndevteam.applicationrunner

import io.github.vndevteam.applicationrunner.common.Constants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ApplicationRunnerApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone(System.getenv("TZ") ?: Constants.DEFAULT_TZ))
	val log: Logger = LoggerFactory.getLogger(ApplicationRunnerApplication::class.java)

	args.forEach {
		log.info("app parameter:$it")
	}
	runApplication<ApplicationRunnerApplication>(*args)
	MDC.clear()
}
