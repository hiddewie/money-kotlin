plugins {
    kotlin("jvm") version "1.4.32"
    id("fr.brouillard.oss.gradle.jgitver") version "0.9.1"
}

group = "nl.hiddewieringa"

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
