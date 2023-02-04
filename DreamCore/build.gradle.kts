plugins {
    kotlin("jvm")
    java
}

group = "br.dargoh"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    compileOnly(fileTree("../dependencias/PaperSpigotAPI.jar"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}