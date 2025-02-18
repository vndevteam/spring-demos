package io.github.vndevteam.applicationrunner.task

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class TaskManager(
    private val tasks: List<Task>,
    private val applicationContext: ConfigurableApplicationContext,
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    fun run(
        name: String,
        args: Any? = null,
    ) {
        val currentTask = tasks.find { it.name == name }

        logger.info("Starting task: $name")
        currentTask?.execute(args)
        logger.info("Finished task: $name")

        logger.info("Shutting down application context")
        SpringApplication.exit(applicationContext)
    }
}