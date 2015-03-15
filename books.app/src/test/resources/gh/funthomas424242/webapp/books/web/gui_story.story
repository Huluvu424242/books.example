Narrative:
In order to die grundlegenden Funktionen der Anwendung zu prüfen
As a tester
I want to einige Stories für die Buchverwaltung definieren.

Scenario: Startseite prüfen

Given der Server ist gestartet
When wir den URL http://localhost:8080/ aufrufen
Then wird die Startseite angezeigt

Scenario: Navigation zum Buch erfassen

Given wir befinden uns auf der Startseite
When wir die Schaltfläche Weiteres Buch erfassen betätigen
Then wird zur Erfassungsseite für Bücher navigiert

Scenario: Buch mit Titel und ISBN erfassen

Given wir befinden uns auf der Erfassungsseite für Bücher
When wir als Titel Die Augen des Drachen eingeben
And als ISBN 3-453-02435-4 erfassen
And die Schaltfläche Buch Registrieren betätigen
Then wird zur Startseite navigiert
And in der Liste der Bücher ein Buch angezeigt
And mit Titel Die Augen des Drachen
And mit ISBN 3-453-02435-4
