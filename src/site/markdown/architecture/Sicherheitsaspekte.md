# Sicherheitsaspekte

**Legende**
Wir halten uns bei den Beschreibungen an die aus der Kryptographie üblichen [Personen](https://de.wikipedia.org/wiki/Alice_und_Bob)
und ihren Rollen:
* Alice, Bob sind die beiden grundlegenden Teilnehmer einer Kommunikation
* Carol, Dave und Ted werden benutzt wenn weitere Teilnehmer benötigt werden
* Eve ist ein passiver Lauscher
* Mallory, Marvin oder Mallet sind aktive Angreifer
* Oscar oder Oskar sind die Gegner von Mallory, Marvin und Mallet
* Peggy und Victor sind Prüfer oder Beweiser
* Trudy ist ein Eindringling
* Trent ist eine vertrauenswürdige Instanz

## URL Angriffe
### URL Wiederholung
Ein absolut simpler Angriff für Eve ist einen Request von Alice oder Bob abzufangen und erneut zu senden. 

**Hintergrund**

Bei HATEOAS darf Eve davon ausgehen das der aktuelle Zustand der Anwendung über die verwendeten URLs beschrieben wird.
Um geschützte Bereiche in der Anwendung bereitzustellen muss dem URL also ein Token beigefügt werden, welches zum Einen
den aktuellen Nutzer eindeutig identifizieren kann und bei einem neuen Request eine Veränderung erfährt welche von
Dritten wie Eve nicht vorausberechnet werden kann.

**Lösungsmöglichkeiten**

1. Die einfachste Möglichkeit einen Nutzer zu identifizieren scheint auf Clientseite eine Nachricht mit dem geheimen
Schlüssel von Alice oder Bob zu signieren und die Signatur auf der Serverseite zu prüfen. Wird die Signatur als
ungültig erkannt muss ein Verhalten definiert werden z.B. Programmabbruch oder Weiterleitung auf einen Anwendungsbereich
welcher der Verwirrung dient. Um die Signatur zu prüfen muss auf der Serverseite der öffentliche Schlüssel von Alice
und Bob vorliegen. Letzteres dürfte kein Problem darstellen, da lediglich eine eMail Adresse benötigt wird um den
öffentlichen Schlüssel von einem Keyserver anzufordern.

 Einige Denkanstösse hierzu:
 * Die UserId könnte signiert werden und dem URL angefügt werden. -> Wirkungslos da Eve den String erlauschen und 
erneut senden kann. Die Kombination würde sich nie ändern, das stellt ein Problem dar.
 * Die UserId und ein Timepad wie vom Google Authenticator wird angehängt. -> Generell wirkungsvoll mit folgenden
möglichen Problemen:
      * Der Timepad wechselt nur jede Minute, mehrere Request innerhalb derselben Minute hätten die
gleiche Kombination. Eve könnte also innerhalb einer Minute den Request wiederholen ohne erkannt zu werden. 
      * Client 
und Server müssen den Timepad exakt berechnen. Dazu wird jeweils eine exakte Zeit benötigt. 
      * Der Server muss als
erstes die Signaturprüfung verdammt schnell durchführen damit er auf den gleichen Timepad kommt. Eine evtl.
Tolleranz würde die Zeitdauer der Angreifbarkeit erhöhen.
 * Den Timepad oder Sicherheitstoken über einen Service im Internet bereitzustellen und dann vom Client wie vom Server abfragen zu lassen
läuft völlig am Ziel vorbei da die Programmquellen offen liegen und Mallory den Abfragealgorithmus in eigene 
Angriffssoftware einbauen könnte oder Eve diese Kenntnis bereits zum Ausnutzen genügt.


