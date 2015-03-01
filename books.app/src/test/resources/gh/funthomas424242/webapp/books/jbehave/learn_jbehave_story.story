Narrative:
In order to learn JBehave
As a tester
I want to define sample story for shopping cart

Scenario: Startseite prüfen

Given der Server ist gestartet
When wir den URL http://localhost:8080/ aufrufen
Then wird die Startseite angezeigt
