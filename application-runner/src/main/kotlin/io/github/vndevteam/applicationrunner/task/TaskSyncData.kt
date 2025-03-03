package io.github.vndevteam.applicationrunner.task

import io.github.vndevteam.applicationrunner.annotations.MeasureExecutionTime
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TaskSyncData : Task {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override val name: String = "SyncData"

    @MeasureExecutionTime
    override fun execute(args: Any?) {
        logger.info("Executing SyncData task")
        logger.info("Masking sensitive data: {\"password\": \"password test\", \"token\": \"token test\"}")
    }
}