plugins {
    `java-library`
}

repositories {
    maven { setUrl("../../repository") }
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:28.1-jre")
    implementation("com.google.guava:listenablefuture:1.0") // this will be a conflict, resolve by removing, or by strategy (if brought in transitively)
}

configurations.all {
    resolutionStrategy.capabilitiesResolution.withCapability("com.google.guava:listenablefuture") {
//        select(candidates.first {
//            it as ModuleComponentIdentifier
//            it.module == "guava"
//        })
    }
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
