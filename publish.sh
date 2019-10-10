#!/usr/bin/env sh
cd libraries
./gradlew publish -PjacksonVersion=2.9.8 -PandroidxVersion=1.0.0
./gradlew publish -PjacksonVersion=2.9.9 -PandroidxVersion=1.0.1
cd ..