#!/usr/bash

cd ..
mvn dependency:copy-dependencies

for jar in $(ls /home/rmoita/dev/projects/webmodel/acceptance-test/target/dependencies/*.jar); do
    CLASSPATH="${CLASSPATH}:${jar}"
done

java -jar bin/fitnesse-standalone.jar -p 8888 -d bin/