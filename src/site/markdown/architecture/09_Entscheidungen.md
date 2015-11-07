
---
[[01_EinfuehrungZiele]( 01_EinfuehrungZiele.md)]

---

# 9 Entscheidungen#

## Versionierung
06.03.2015 In dem Projekt ist [Semantische Versionierung](SemantischeVersionierung.md) zu nutzen.

## Client Server Schnittstelle
* Die Anwendung wird als Sammlung von Microservices realisiert
* Das Backend wird als REST Service implementiert
* Das Frontend wird als reine AngularJS Anwendung implementiert
* Die GUI wird über AngularUI und Bootstrap realisiert
* Die Kommunikation zwischen Server und Client erfolgt zustandslos im Sinne von HATEOAS
* Weder im Client noch im Server soll ein Zustand gehalten werden. 
* Ein durch obige Entscheidungen entstehendes hohes Aufkommen an Requests wird akzeptiert
* Das Deployment soll über DockerContainer erfolgen

Entscheidung getroffen am 07.11.2015 auf folgenden Grundlagen:
* Über ein REST Backend kann eine möglichst lose Kopplung vom Client realisiert werden.
* Durch die Zustandslose Kommunikation vereinfachen sich Loadbalancing und Failover Szenarien, da keine Sessionreplikation benötigt wird.
* Durch die Erzeugung von Docker Images können bei Bedarf weitere Container bedarfsgerecht von einem Imagae erzeugt werden und dadurch kann ein Skallieren der Anwendung auf einfachste Art ermöglicht werden.
* Durch den konsequenten Einsatz von HATEOAS benötigt der Client keine Information über die URLs des Backends (bis auf den Einstieg URL). Dadurch können die URLs vom Backend nach Belieben spontan geändert werden. 
* Als GUI Framework AngularUI und Bootstrap zu verwenden wird als gut erachtet, da es aktuell sehr verbreitet ist und schneller Support über eine aktive Community gewährleistet ist.
* **RISIKO (sehr gering)** Aktuell wird die Verwendung von AngularJS als Risiko eingestuft. Hintergrund ist der gerade stattfindende API Bruch durch die Entwicklung von AngularJS v2. Da jedoch die Migrationsstrategie öffentlich von der Community auf github entwickelt wird wird dieses Risiko als sehr gering eingestuft.
* **RISKO (gering)** Die Frontendlogik im Kern auf eine Realisierung mittels Javascript auszurichten wird als Risiko erkannt, da hier vermutlich eine weitere, komplett neue Toolchain zur Entwicklung des Frontends sowie völlig andere technische Skills als in der Backend Entwicklung benötigt werden. Das Risiko wird als gering (also deutlich mehr Aufwand als bei sehr gering) eingestuft und als Herausforderung an den Entwickler gesehen. 

## Authentifizierung & Authorisierung
* Zur Authentifizierung muss sich der Nutzer beim Programm registrieren und dort einen öffentlichen PGP Key hinterlegen oder Daten (z.B. eMail) mit denen der Key aus dem Netz geholt werden kann.
* Zur Authorisierung wird an jeden URL eine UserId und ein Rechtestring angehangen aus dem die Anwendung die Identität und die aktuellen Rechte des Nutzers ermitteln kann. Die Sicherheitsinformationen sind zu zu erzeugen, dass einfache Angriffe wie nochmaliges Absetzen des kopierten Requests durch einen anderen Nutzer wirkungsvoll verhindert werden. 
* Jeder Nutzer muss sich beliebig oft registrieren und jeweils den gleichen öffentlichen PGP hinterlegen können. Die Anwendung muss es ermöglichen das der Nutzer auch Zugriff auf seine anderen (als Nutzer mit anderer id aber gleichen öffentlichen Schlüssel) Daten erhält. Hierzu sind die Eigenschaften des Public Key Verfahrens zu nutzen (Prüfung der Signatur mittels hinterlegten öffentlichen Schlüssel).
* Realisierung: Bei der Registrierung hinterlegt der Nutzer eine eMail Adresse über welche das Backend den öffentlichen PGP Schlüssel des Nutzers von einem Key Server erhalten kann. Beim Request wird an den URL die vom Backend vergebene UserId und ein Timepad (ala Google Authenticator) angehangen. Das Backend kann sich den Timepad aus den beim User hinterlegten Daten 2. Schlüsselspaares  (ein privater vom Server generierte Schlüssel und der öffentliche dazu) ebenso berechnen.

Entscheidungen getroffen am 07.11.2015 auf folgenden Grundlagen:
* Die Erzeugung eines Timepads scheint aktuell die einfachste Möglichkeit zu sein einen Schlüssel unabhängig von der Kontaktaufnahme zu anderen Zertifizierungsservern zu sein.
* Alle mir bekannten anderen Verfahren würden auf das Halten von Sessioninformationen hinauslaufen um den User sicher zu identifizieren und Kopien von Requests abzuschmettern. Auch soll der Nutzer ja in mehreren Browsern die Anwendung parallel bedienen können ohne die Workflows gegenseitig zu beeinflussen. 



## Testkonzept
### Modultest
* HTML Seiten werden mit HTMLUnit auf korrekte Struktur getestet
* JavaScript wird getetestet mit?
  * Jasmine
* Java wird getestet mit:
  * jUnit
  * TestNG 
=> (25.04.2015 Entscheidung für jUnit da keine Vorteile von TestNG gegenüber jUnit bekannt)
* REST API wird getestet mit - Entscheidung noch offen:
  * RAML - sehr strukturiert aber noch viele Integrationsprobleme. Mischt Konzepte aus Swagger und API Blueprint.
  * Swagger - scheint der stabilste Kandidat zu sein (Beispiel? https://github.com/kenshoo/swagger-validator)
  * WADL
  * I/O Docs
  * API Blueprint
  * http://www.bibsonomy.org/bibtex/294f86c9f252fc214081f44e7fdca5bed/funthomas424242

## Verteilte Konzepte
### Verteilung und Abgleich der Änderungen im Netz ###
10.04.2015 Damit die Clients autark arbeiten und dennoch Informationen an alle anderen Clients verteilen können ohne diese Clients oder deren Nutzer zu kennen, wird ein verteiltes Informationssystem benötigt an welches Aktualisierungen gesendet und über das Suchen ausgeführt werden können. Also zur Verteilung und zum Auslesen der Informationen wird ein Suchserver wie google benötigt. 

**Entscheidung:** Als Suchserver wird YaCy benutzt, da dieser sowohl lokal installiert als auch anonym mit Informationen versorgt und themenspezifisch konfiguriert werden kann.

### Verteilte Account- und Datenverwaltung ###
10.04.2015:
* Nutzer werden über eine UUID weltweit eindeutig identifiziert
* Die Daten jedes Nutzers liegen stets verschlüsselt in der Datenbank:
  * Zur Verschlüsselung wird ein Nutzerspezifischer Schlüssel verwendet. 
  * Der Schlüssel selbst stellt einen symmetrischen Schlüssel dar damit mittels symmetrischen Verfahren die Datenbankzugriffe möglichst schnell ausgeführt werden. 
  * Der symmetrische Schlüssel selber wird über ein asymetrisches Verfahren (PGP) verschlüsselt in der Datenbank abgelegt. 
  * Jeder Nutzer verfügt über einen spezifischen symmetrischen Schlüssel, so dass nach Knacken eines Schlüssels nicht die Daten aller Nutzer verloren sind. 
  * Der Login Mechanismus wird über ein asymmetrisches Verfahren abgehandelt.
 
---
[[01_EinfuehrungZiele]( 01_EinfuehrungZiele.md)]

---


