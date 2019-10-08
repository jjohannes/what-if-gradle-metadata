plugins {
    `java-library`
}

repositories {
    maven { setUrl("../../repository") }
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:28.1-jre")
    implementation("com.google.collections:google-collections:1.0") // this will be a conflict, resolve by removing, or by strategy (if brought in transitively)
}

configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("com.google.collections:google-collections") {
        // select("com.google.guava:guava:28.1-jre")
    }
}
