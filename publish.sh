#!/usr/bin/env sh
cd libraries
./gradlew publish -PjacksonVersion=2.9.8
./gradlew publish -PjacksonVersion=2.9.9
cd ..