plugins {
    kotlin("jvm") version "1.4.32"
}

group = "nl.hiddewieringa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    api("javax.money", "money-api", "1.1")
    implementation(kotlin("stdlib"))

    testImplementation("org.javamoney", "moneta", "1.4.2")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.7.1")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }
}
