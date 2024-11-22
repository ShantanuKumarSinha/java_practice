plugins {
    id("java")
}

object Dependencies {
    var lombokVersion = "1.18.36"
    var jacksonVersion = "2.16.1"
    var junitVersion = "5.9.1"
    var junitJupiterVersion = "5.9.1"
}
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:${Dependencies.lombokVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${Dependencies.jacksonVersion}")
    testImplementation(platform("org.junit:junit-bom:${Dependencies.junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Dependencies.junitJupiterVersion}")
}

tasks.test {
    useJUnitPlatform()
}