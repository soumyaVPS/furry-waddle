plugins {
    java
    kotlin("jvm") version "1.6.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"
application {
    mainClass.set("Day22_3Kt")
}

repositories {
    mavenCentral()
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.9")

        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

}
