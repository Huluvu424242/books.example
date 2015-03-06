# books.example
Bücherverwaltung mit JPA aber ohne Applicationserver (mittels spring boot)

Build Status:
[![Build Status](https://travis-ci.org/FunThomas424242/books.example.svg?branch=master)](https://travis-ci.org/FunThomas424242/books.example)

Es gibt auch weitere [Dokumentation](src/site/markdown/index.md) zum Projekt

Das Projekt basiert auf Kode und Erkenntnissen folgender Quellen und Projekte:

* Spring Boot Konfiguration
    * https://github.com/ewolff/spring-boot-demos 
* Cucumber-JVM Integration in Spring
    * https://github.com/cucumber/cucumber-java-skeleton
    * https://github.com/excellentdrums/Cucumber-JVM-Spring-MVC-Test-HTMLUnit-Demo
    * http://testerstories.com/2014/06/an-introduction-to-using-cucumber-jvm/
    * http://liminescence.blogspot.de/2013/08/integration-testing-with-spring.html
* JBehave Integration in Spring
    * https://github.com/mkuthan/example-jbehave
    * http://mkuthan.github.io/blog/2014/05/29/acceptance-testing-using-jbehave-spring-framework-and-maven/
* PGP Integration
    * http://www.javacodegeeks.com/2011/06/java-pretty-good-privacy-pgp.html

# Ausprobieren
1. Zum Ausprobieren bitte zunächst das Projekt auschecken mit git clone https://github.com/FunThomas424242/books.example.git
2. Anschließend in das books.app Unterverzeichnis wechseln.
3. Dort das Projekt bauen mit mvn  -U clean install
4. Dann starten mit java -jar target/books.app-1.0.0-SNAPSHOT.jar
5. Per Webbrowser die URL http://localhost:8080/ aufrufen und das Projekt ausprobieren.

