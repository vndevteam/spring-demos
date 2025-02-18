package io.github.vndevteam.applicationrunner.aop

import io.github.vndevteam.applicationrunner.common.Constants
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import kotlin.system.measureTimeMillis

@Aspect
@Component
class ExecutionTimeAspect {
    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    @Around("@annotation(io.github.vndevteam.applicationrunner.annotations.MeasureExecutionTime)")
    fun measureExecutionTime(joinPoint: ProceedingJoinPoint): Any? {
        var result: Any?
        val executionTime =
            measureTimeMillis {
                result = joinPoint.proceed()
            }

        logger.info("${joinPoint.signature} runs for: $executionTime ms")

        if (executionTime >= Constants.SYNC_EXECUTION_WARN_THRESHOLD_MS) {
            val executionMinutes = executionTime / 60 / 1000
            logger.warn("Sync has been run for $executionMinutes minutes")
        }

        return result
    }
}
