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

tasks.create("checkClasspath") {
    doLast {
        val compile = configurations.compileClasspath.get().map { it.name }
        val rt = configurations.runtimeClasspath.get().map { it.name }
        println("=== COMPILE ===")
        compile.forEach { println(it) }
        println("=== RUNTIME ===") // the annotation libraries should not be on the runtime classpath
        rt.forEach { println(it) }
    }
}