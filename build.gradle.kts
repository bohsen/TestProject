import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.5.0-M2"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.useIR = true

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.mockito:mockito-core:3.7.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.nhaarman:expect.kt:1.0.0")
    // testImplementation("org.mockito:mockito-inline:3.7.0")
}
