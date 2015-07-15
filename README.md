# ![Books Logo](./books.app/src/main/resources/static/img/Lieblingsbuch149x149.png) books.example
Bücherverwaltung mit JPA aber ohne Applicationserver (mittels spring boot)

[![Build Status](https://travis-ci.org/FunThomas424242/books.example.svg?branch=master)](https://travis-ci.org/FunThomas424242/books.example)
[ ![Download Releases](./src/main/resources/img/Releases.png) ](https://bintray.com/funthomas424242/books.example/books.example/_latestVersion)
[ ![Download Snapshots](./src/main/resources/img/Snapshots.png) ](http://oss.jfrog.org/simple/oss-snapshot-local/gh/funthomas424242/webapp/books.app/)

Es gibt auch weitere [Dokumentation](src/site/markdown/index.md) zum Projekt

Das Projekt basiert auf Kode und Erkenntnissen folgender Quellen und Projekte:

* Spring Boot Konfiguration
    * https://github.com/ewolff/spring-boot-demos 
    * http://www.leveluplunch.com/java/tutorials/019-disable-actuator-endpoints-in-spring-boot/
* Cucumber-JVM Integration in Spring
    * https://github.com/cucumber/cucumber-java-skeleton
    * https://github.com/excellentdrums/Cucumber-JVM-Spring-MVC-Test-HTMLUnit-Demo
    * http://testerstories.com/2014/06/an-introduction-to-using-cucumber-jvm/
    * http://liminescence.blogspot.de/2013/08/integration-testing-with-spring.html
* JBehave Integration in Spring
    * https://github.com/mkuthan/example-jbehave
    * http://mkuthan.github.io/blog/2014/05/29/acceptance-testing-using-jbehave-spring-framework-and-maven/
* Debian Archiv Erstellung
    * http://debian-maven.sourceforge.net/project-info.html
    * https://wiki.debian.org/Teams/JavaPackaging
    * https://wiki.debian.org/JavaPackage
* PGP Integration
    * http://www.javacodegeeks.com/2011/06/java-pretty-good-privacy-pgp.html
* Bintray / JFroge Integration
    * https://www.jfrog.com/confluence/pages/viewpage.action?pageId=26083425
* AngularJS UI Grid
   * http://ui-grid.info/docs/#/tutorial/401_AllFeatures


# Ausprobieren
1. Zum Ausprobieren bitte zunächst das Projekt auschecken mit git clone https://github.com/FunThomas424242/books.example.git
1. Dann das Projekt bauen mit mvn  -U clean install
1. Und starten mit java -jar books.app/target/books.app-0.1.0-SNAPSHOT.jar oder hot deploy über  mvn spring-boot:run
1. Per Webbrowser die URL [http://localhost:8080/](http://localhost:8080/) aufrufen und das Projekt ausprobieren.
2. Herunterfahren funktioniert über eine Console mittels  curl -X POST http://localhost:8080/shutdown oder in der gestarteten Console über Ctrl+C ;)

