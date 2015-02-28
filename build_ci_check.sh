#!/bin/sh
export ciserver=true
mvn clean
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
mvn test -B
