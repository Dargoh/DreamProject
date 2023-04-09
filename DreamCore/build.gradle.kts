plugins {
    kotlin("jvm")
    java
}

group = "br.dargoh"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    compileOnly(fileTree("../dependencias/PaperSpigotAPI.jar"))
    compileOnly(fileTree("../dependencias/Vault.jar"))

    compileOnly(fileTree("../dependencias/BossBarAPI.jar"))
    compileOnly(fileTree("../dependencias/HologramAPI.jar"))
    compileOnly(fileTree("../dependencias/TitleAPI.jar"))
    compileOnly(fileTree("../dependencias/ActionBarAPI.jar"))

    compileOnly(fileTree("../dependencias/ProtocolLib.jar"))

    compileOnly(fileTree("../dependencias/NDatabase.jar"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}