import java.net.URL

subprojects {
    plugins.withType<MavenPublishPlugin> {
        extensions.getByType<PublishingExtension>().repositories {
            maven {
                name = "repository"
                url = uri("file://${rootDir}/../repository")
            }
        }
    }
    tasks.withType<Jar> {
        actions = listOf()
        doLast {
            val path = project.group.toString().replace('.', '/') + '/' + project.name + '/' + project.version + '/' + archiveFileName.get()
            archiveFile.get().asFile.writeBytes(URL("https://repo1.maven.org/maven2/$path").readBytes())
        }
    }
}