## What's the use case?

Guava publishes two variants: one for JDK6+ and one for JDK8+.
In an attempt to avoid both variants in a dependency graph, the "variant name" is encoded in the version.
Each Guava version is published twice: `28.1-android` (JDK6) and `28.1-jre` (JDK8)

## How is it solved?

In Gradle Module Metadata, _variants_ are published explicitly.
In java, there typically is a _runtime classpath variant_ (usually called `runtimeElements` in Gradle Module Metadata) and a _compile classpath variant_ (usually called `apiElements`).
Each variant has its dependencies explicitly defined in the metadata.
This allows for dependencies that are only defined in the `apiElements` variant.
(In contrast, the POM scope "compile" defines dependencies for both _compile classpath_ and _runtime classpath_ and there is no scope for **only** _compile classpath_.)