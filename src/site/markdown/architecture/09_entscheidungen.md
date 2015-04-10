#9 Entscheidungen#

## Versionierung
06.03.2015 In dem Projekt ist [semantische Versionierung](semantischeVersionierung.md) zu nutzen.

## Verteilte Konzepte
### Verteilung und Abgleich der Änderungen im Netz ###
10.04.2015 Damit die Clients autark arbeiten und dennoch Informationen an alle anderen Clients verteilen können ohne diese Clients oder deren Nutzer zu kennen, wird ein verteiltes Informationssystem benötigt an welches Aktualisierungen gesendet und über das Suchen ausgeführt werden können. Also zur Verteilung und zum Auslesen der Informationen wird ein Suchserver wie google benötigt. 

**Entscheidung:** Als Suchserver wird YaCy benutzt, da dieser sowohl lokal installiert als auch anonym mit Informationen versorgt und themenspezifisch konfiguriert werden kann.

### Verteilte Account- und Datenverwaltung ###
10.04.2015:
* Nutzer werden über eine UUID weltweit eindeutig identifiziert
* Die Daten jedes Nutzers liegen stets verschlüsselt in der Datenbank:
  ** Zur Verschlüsselung wird ein Nutzerspezifischer Schlüssel verwendet. 
  ** Der Schlüssel selbst stellt einen symmetrischen Schlüssel dar damit mittels symmetrischen Verfahren die Datenbankzugriffe möglichst schnell ausgeführt werden. 
  ** Der symmetrische Schlüssel selber wird über ein asymetrisches Verfahren (PGP) verschlüsselt in der Datenbank abgelegt. 
  ** Jeder Nutzer verfügt über einen spezifischen symmetrischen Schlüssel, so dass nach Knacken eines Schlüssels nicht die Daten aller Nutzer verloren sind. 
  ** Der Login Mechanismus wird über ein asymmetrisches Verfahren abgehandelt.
