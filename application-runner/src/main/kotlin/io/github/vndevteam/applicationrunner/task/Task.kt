package io.github.vndevteam.applicationrunner.task

/**
 * This is the interface for the Task.
 * This interface is used to execute the task.
 * @property name The name of the task. We define all name in Constants
 * @properties args The arguments for the task, it is any type
 */
interface Task {
    val name: String

    fun execute(args: Any? = null)
}