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

java {
    targetCompatibility = JavaVersion.VERSION_1_6 // <- increase to 8 or higher get the 'jre' instead of the 'android' jar, decrease to fail
}

tasks.create("checkClasspath") {
    doLast {
        val compile = configurations.compileClasspath.get().map { it.name }
        val rt = configurations.runtimeClasspath.get().map { it.name }
        println("=== COMPILE ===")
        compile.forEach { println(it) }
        println("=== RUNTIME ===")
        rt.forEach { println(it) }
    }
}