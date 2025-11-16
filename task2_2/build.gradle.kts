plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.seleniumhq.selenium:selenium-java:4.38.0")
    implementation("com.github.javafaker:javafaker:1.0.2")
    implementation("io.github.bonigarcia:webdrivermanager:6.3.2")
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

tasks.test {
    useJUnitPlatform()
}