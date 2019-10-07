plugins {
    `java-library`
}

repositories {
    maven { setUrl("../../repository") }
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:28.1-jre")
}
