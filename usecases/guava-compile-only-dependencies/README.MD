**NOTE:**

This use cases also works with a real fork of Guava that publishes Gradle Module Metadata.
Execute the following in the parent directory of this repository:

```
git clone git@github.com:jjohannes/guava.git
cd guava
git checkout gradle-module-metadata
util/set_version.sh 28.1
mvn -DskipTests=true install
mvn -DskipTests=true install -f android
```

## What's the use case?

Guava defines dependencies to annotation libraries only needed at compile time.
It is not possible to express this in POM metadata.
See also discussion here: https://github.com/google/guava/issues/2824

## How is it solved?

In Gradle Module Metadata, _variants_ are published explicitly.
In java, there typically is a _runtime classpath variant_ (usually called `runtimeElements` in GMM) and a _compile classpath variant_ (usually called `apiElements`).
Each variant has their dependencies explicitly defined in the metadata.
This allows for dependencies that are only defined in the `apiElements`.
(In contrast, the POM scope "compile" defines dependencies for both _compile classpath_ and _runtime classpath_ and there is no scope for **only** _compile classpath_.)