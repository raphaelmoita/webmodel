#!/bin/bash

#export SPRING_PROFILES_ACTIVE=fitnesse

export JAVA_HOME=/home/rmoita/softwares/jdk1.8.0_181/
export MVN_HOME=/home/rmoita/softwares/apache-maven-3.5.2/

cd ..

${MVN_HOME}/bin/mvn dependency:copy-dependencies

for jar in $(ls target/dependencies/*.jar); do
    CLASSPATH="${CLASSPATH}:${jar}"
done

SPRING_PROFILES_ACTIVE=fitnesse ${JAVA_HOME}/bin/java -jar bin/fitnesse-standalone.jar -p 8888 -d bin/ -e 0 -l bin/logs