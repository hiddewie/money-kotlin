import fr.brouillard.oss.jgitver.Strategies

plugins {
    kotlin("jvm") version "2.0.0"
    id("fr.brouillard.oss.gradle.jgitver") version "0.9.1"
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "1.0.0"
}

group = "nl.hiddewieringa"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
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
}

signing {
    sign(publishing.publications)
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}
