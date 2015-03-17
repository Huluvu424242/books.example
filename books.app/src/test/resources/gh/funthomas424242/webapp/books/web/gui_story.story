Narrative:
In order to die grundlegenden Funktionen der Anwendung zu prüfen
As a tester
I want to einige Stories für die Buchverwaltung definieren.

Scenario: Startseite prüfen

Given der Server ist gestartet
When wir den URL http://localhost:8080/ aufrufen
Then wird auf die Startseite weitergeleitet

Scenario: Navigation zum Buch erfassen

Given wir befinden uns auf der Startseite
When wir die Schaltfläche zum Erfassen eines Buches betätigen
Then wird zur Erfassungsseite für Bücher navigiert

Scenario: Buch mit Titel und ISBN erfassen

Given wir befinden uns auf der Erfassungsseite für Bücher
When wir als Titel Die Augen des Drachen eingeben
And als ISBN 3-453-02435-4 erfassen
And die Schaltfläche zum Buch registrieren betätigen
Then wird zur Startseite navigiert
And in der Liste der Bücher ein Buch angezeigt
And mit Titel Die Augen des Drachen
And mit ISBN 3-453-02435-4

Scenario: Buch löschen

Given wir befinden uns auf der Startseite
And die Bücherliste enthält das Buch Die Augen des Drachen in Zeile 1
When wir das Mülleimersymbol betätigen
Then erscheint die Rückfrage Möchten Sie das Buch Die Augen des Drachen mit ID 1 wirklich löschen?

