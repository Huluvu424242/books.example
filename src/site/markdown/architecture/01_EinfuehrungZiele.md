# Einführung und Ziele
## Aufgabenstellung
Es ist eine Buchverwaltung zu erstellen, welche besonderen Wert auf den Schutz der Privatspähre und der eigenen
Daten legt. Die Buchverwaltung soll als Desktopapplication über normale Betriebsmittel wie Paketverwaltungen,
Installer oder Webstart installiert werden können.

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
