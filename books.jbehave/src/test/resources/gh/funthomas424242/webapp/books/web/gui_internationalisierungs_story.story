Narrative:
In order to die Anwendung international ausliefern zu können
As a Hersteller
I want to die Oberfläche in den Sprachen Englisch und Deutsch anbieten.

Scenario: Startseite in Deutsch prüfen


Given unsere Sprache ist Deutsch.
When wir navigieren zur Startseite,
Then finden wir eine Schaltfläche welche Weiteres Buch erfassen lautet.
And eine Überschrift Bücherregal.
And eine Tabelle mit den Spalten: ID,Titel,ISBN.

Scenario: Startseite in Englisch prüfen

Given unsere Sprache ist Englisch.
When wir navigieren zur Startseite,
Then finden wir eine Schaltfläche welche Register a new book lautet.

