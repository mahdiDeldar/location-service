#!/usr/bin/env bash

./gradlew clean bootJar
mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)
docker build -t shervin/location_service:$(./gradlew properties -q | grep version | awk '{print $2}') .
docker tag shervin/location_service:$(./gradlew properties -q | grep version | awk '{print $2}') shervin/location_service:latest
