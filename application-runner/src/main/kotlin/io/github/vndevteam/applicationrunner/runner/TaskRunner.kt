package io.github.vndevteam.applicationrunner.runner

import io.github.vndevteam.applicationrunner.common.Constants
import io.github.vndevteam.applicationrunner.task.TaskManager
import org.slf4j.MDC
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class TaskRunner(
    private val taskManager: TaskManager,
): ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        if (args != null) {
            val taskName = args.getOptionValues(Constants.Arguments.TASK_NAME).firstOrNull()

            if (taskName != null) {
                MDC.put("taskName", taskName)
                taskManager.run(name = taskName, "Test Parameter")
            } else {
                println("Task name is required")
            }
        }
    }
}