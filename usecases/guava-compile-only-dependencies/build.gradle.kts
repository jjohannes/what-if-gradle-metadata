plugins {
    `java-library`
}

repositories {
    maven { setUrl(rootProject.file("repository")) }
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:28.1-jre")
}
