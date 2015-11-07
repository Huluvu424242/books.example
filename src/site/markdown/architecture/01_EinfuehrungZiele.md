
---
[[09_Entscheidungen](09_Entscheidungen.md)]

---
# Einführung und Ziele
## Aufgabenstellung
Es ist eine Buchverwaltung zu erstellen, welche besonderen Wert auf den Schutz der Privatspähre und der eigenen
Daten legt. Die Buchverwaltung soll als Desktopapplication über normale Betriebsmittel wie Paketverwaltungen,
Installer oder Webstart installiert werden können. Bedient wird die Anwendung über einen Browser. Der Nutzer kann gern auch mehrere Browser parallel mit dem gleichen Account benutzen und dort verschiedene Workflows abarbeiten welche sich nicht gegenseitig stören dürfen. Auch muss es möglich sein das ein Nutzer sich neu registriert und den gleichen öffentlichen PGP Schlüssel im System hinterlegt wie bei vorherigen Registrierungen. Dabei muss die Anwendung sicherstellen, dass der Nutzer auch auf die Daten der alten Accounts noch zugreifen kann. Eine Anbindung an andere soziale Netzwerke wie bookcrossing.com oder minds.org soll realisiert werden. Als Login Mechanismus soll ein neues, verteilt arbeitendes und sicheres Verfahren genutzt werden bei dem ein Passwort vergessen nicht mehr problematisch ist oder gar nicht mehr vorkommen kann. Davon ausgenommen wird die Problematik des Vergessens der PGP Passphrase. Letzteres darf durchaus zu unnutzbaren Accounts führen. Die Authentifizierung soll möglichst einfach per SmartCard oder GoogleAuthenticator ermöglicht werden. Die Verfahren sollen so einfach wie das Hantieren mit einer PhotoTan oder das Verwenden eines Seeds sein.

## Qualitätsziele
## Stakeholder
* Projektowner
* Open Source Entwickler
* BookCrossing Nutzer
* Buchleser
* Minds.org und andere soziale Netzwerke

## Randbedingungen
* Die Entwicklung erfolgt auf einem Unix System auf andere OS ist keine Rücksicht zu nehmen.
* Die Auslieferung der Anwendung ist für Unix System über die bereitgestellten Paketmanager angedacht. Die zusätzliche Verteilung auf andere OS ist gewünscht und sollte so gut wie möglich unterstützt werden.
* Die Nutzung der Anwendung erfolgt per Browser. Dabei sollte es keine Rolle spielen welcher Browser benutzt wird.
* Die Barrierefreiheit der GUI ist sicherzustellen.
* Die Verwendete Toolchain für Versionierung, CI und Auslieferung soll über kostenlose Tools/Hoster im Internet erfolgen.
* Ein tägliches Backup auf einen selbstverwalteten Rechner soll stets sichergestellt werden. Wobei nur bei Änderungen automatisiert ein Backup erstellt und heruntergeladen werden soll. (Idealerweise wird das Backup automatisiert über einen Raspberry Pi erstellt und eine Kopie auf private Massendatenträger abgelegt).

---
[[09_Entscheidungen](09_Entscheidungen.md)]

---
