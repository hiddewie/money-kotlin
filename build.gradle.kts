import fr.brouillard.oss.jgitver.Strategies
import java.net.URI

plugins {
    kotlin("jvm") version "1.4.32"
    id("fr.brouillard.oss.gradle.jgitver") version "0.9.1"
    `maven-publish`
    signing
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

java {
    withJavadocJar()
    withSourcesJar()
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

jgitver {
    strategy(Strategies.MAVEN)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name.set("Money Kotlin")
                description.set("Kotlin extensions for javax.money (Moneta) JSR 354")
                url.set("https://github.com/hiddewie/money-kotlin")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("hiddewie")
                        name.set("Hidde Wieringa")
                        email.set("hidde@hiddewieringa.nl")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:hiddewie/money-kotlin.git")
                    developerConnection.set("scm:git:ssh://github.com:hiddewie/money-kotlin.git")
                    url.set("https://github.com/hiddewie/money-kotlin/tree/master")
                }
            }

            from(components["java"])
        }
    }

    repositories {
        maven {
            url = if (version.toString().endsWith("-SNAPSHOT")) {
                URI("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            } else {
                URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            }
            credentials {
                username = project.property("ossrhUsername").toString()
                password = project.property("ossrhPassword").toString()
            }
        }
    }
}

signing {
    sign(publishing.publications)
}