# books.example
Bücherverwaltung mit JPA aber ohne Applicationserver (mittels spring boot)

books.app:
[![Build Status](https://travis-ci.org/FunThomas424242/books.example.svg?branch=master)](https://travis-ci.org/FunThomas424242/books.example)

Das Projekt basiert auf Kode und Erkenntnissen folgender Quellen und Projekte:

* Spring Boot Konfiguration
    * https://github.com/ewolff/spring-boot-demos 
* JBehave Integration in Spring
    * https://github.com/mkuthan/example-jbehave
    * http://mkuthan.github.io/blog/2014/05/29/acceptance-testing-using-jbehave-spring-framework-and-maven/


*Ausprobieren*
1. Zum Ausprobieren bitte zunächst das Projekt auschecken mit git clone https://github.com/FunThomas424242/books.example.git
2. Anschließend in das books.app Unterverzeichnis wechseln.
3. Dort das Projekt bauen mit mvn  -U clean install
4. Dann starten mit java -jar target/books.app-1.0.0-SNAPSHOT.jar
5. Per Webbrowser die URL http://localhost:8080/ aufrufen und das Projekt ausprobieren.

