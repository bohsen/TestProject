import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.4.21"
}

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        println("Configuring $name in project ${project.name}...")
        kotlinOptions {
            useIR = true
        }
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.mockito:mockito-core:3.7.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    testImplementation("junit:junit:4.13.1")
    testImplementation("com.nhaarman:expect.kt:1.0.0")
    // testImplementation("org.mockito:mockito-inline:3.7.0")
}
