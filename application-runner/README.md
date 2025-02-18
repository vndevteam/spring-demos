# Application Runner

## Overview
Application Runner is a Kotlin-based Spring Boot application designed to execute various tasks with logging and execution time measurement.

## Features
- Task execution with logging
- Execution time measurement using AOP
- Pre-commit and pre-push Git hooks

## Requirements
- JDK 21
- Gradle
- Kotlin 1.9.25
- Spring Boot 3.4.2

## Setup
1. Clone the repository:
    ```sh
    git clone https://github.com/vndevteam/application-runner.git
    cd application-runner
    ```

2. Build the project:
    ```sh
    ./gradlew build
    ```

3. Run the application:
    ```sh
    ./gradlew bootRun
    ```

## Project Structure
- `build.gradle.kts`: Gradle build script
- `src/main/kotlin/io/github/vndevteam/applicationrunner/task/TaskSyncData.kt`: Task implementation
- `src/main/kotlin/io/github/vndevteam/applicationrunner/aop/ExecutionTimeAspect.kt`: AOP aspect for measuring execution time

## Usage
To execute the `SyncData` task, run the application and check the logs for execution details and time measurements.

## License
This project is licensed under the MIT License.