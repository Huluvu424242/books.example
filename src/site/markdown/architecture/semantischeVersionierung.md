#Semantische Versionierung#
##Grundlagen##

Versionsnummer: Major,Minor,Patch

Major: Änderungen die das API brechen
Minor: Änderungen durch Hinzufügen neuer Features ohne Bruch der API
Patch: Änderungen zur Fehlerbehebung ohne Bruch der API

##Sicherstellung über TCK##
TCK: Technical Compatibility Kit

Eine Testsuite die sicherstellt, dass das API nicht gebrochen wurde.

##Was ist das API##
Um den Bruch der API über ein TCK feststellen zu können muss geklärt sein was das API darstellt.
Das API sind alle Schnittstellen die nach außen gegeben werden. Bei einer Webanwendung wie books.example 
ist diese Schnittstelle scheinbar nicht vorhanden. Versetzt man sich allerdings in die Lage des Nutzers
welcher die Anwendung installiert und zum Releasewechsel aktualisiert so gibt es folgende Dinge die 
als API in Betracht kommen:
* Die Datenbank Entitäten. Ein Nutzer wird für das neue Release den Datenbestand nicht löschen und damit müssen die
  Änderungen an den Entitäten abwärtskompatible erfolgen.
* Änderungen an Registry Einträgen oder am Format von Konfigurationsdateien welche am Nutzer PC angelegt wurden
  und nicht mit der Anwendung verteilt werden.
* Änderungen an Exportformaten
* Änderungen an Formaten welche zum Push ins Internet (soziale Netze) verwendet werden.
* Änderungen am Format der uuid zur Nutzeridentifikation

##Bau eines TCK##



