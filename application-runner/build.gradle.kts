plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "io.github.vndevteam"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("net.logstash.logback:logstash-logback-encoder:8.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<Copy>("copyPreCommitHook") {
	group = "git hooks"
	description = "Copy pre-commit hook from the scripts/hooks to .git/hooks directory"
	outputs.upToDateWhen { false }
	from(file("scripts/hooks/pre-commit"))
	into(file(".git/hooks"))
}

tasks.register<Copy>("copyPrePushHook") {
	group = "git hooks"
	description = "Copy pre-push hook from the scripts/hooks to .git/hooks directory"
	outputs.upToDateWhen { false }
	from(file("scripts/hooks/pre-push"))
	into(file(".git/hooks"))
}

tasks.build {
	dependsOn("copyPreCommitHook", "copyPrePushHook")
}
