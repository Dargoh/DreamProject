plugins {
    kotlin("jvm") version "1.5.10"
    java
}

group = "br.dargoh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

subprojects {
    buildDir = File(rootProject.projectDir, "gradleBuild/" + project.name)

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}