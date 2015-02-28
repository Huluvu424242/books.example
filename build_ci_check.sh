#!/bin/sh
rm -f ~/bookdb.*
mvn clean
mvn install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
mvn test -B
