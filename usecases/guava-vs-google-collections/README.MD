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

In the past, the collection part of Guava was published under different coordinates `com.google.collections:google-collections`.
In POM metadata, such a relationship between modules, i.e. one replaces the other and both cannot be used together, cannot be expressed.

## How is it solved?

This is similar to the [guava-listenablefuture-conflict](../guava-listenablefuture-conflict) use case and solved in a similar manner by letting Guava express that it provides the `com.google.collections:google-collections` capability.