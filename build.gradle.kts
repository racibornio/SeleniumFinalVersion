plugins {
    id("java")
}

group = "com.patryk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation(dependencyNotation = "ch.qos.logback:logback-classic:1.4.11")
    implementation(dependencyNotation = "io.github.bonigarcia:webdrivermanager:5.5.3")
}

tasks.test {
    useJUnitPlatform()
}