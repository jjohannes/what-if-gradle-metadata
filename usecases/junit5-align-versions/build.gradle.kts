plugins {
    `java-library`
}

repositories {
    maven { setUrl("snapshot-repo") } // <- repository with Gradle Module Metadata SNAPSHOT
    maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter-api:5.6.0-SNAPSHOT")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.5.2") // should automatically align with core to 5.6.0-SNAPSHOT
}
