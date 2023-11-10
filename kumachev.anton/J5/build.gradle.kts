plugins {
    id("java")
}

group = "com.kumachev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("junit:junit:4.13.1")
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.javatuples:javatuples:1.2")
}

tasks.test {
    useJUnitPlatform()
}