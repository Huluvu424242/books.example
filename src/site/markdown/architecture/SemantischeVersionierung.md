# Semantische Versionierung#

## Quellen
* http://semver.org/

  ( bis mal jemand schafft die deutsche Übersetzung als Pull Request zu formulieren findet man sie [hier](http://blog.selfhtml.org/2013/11/08/semantische-versionsnumerierung-2-0-0/) )
* https://jaxenter.de/semantic-versioning-1034
* http://de.slideshare.net/mfrancis/osgi-community-event-2010-automated-semantic-versioning-for-osgi-bundles

## Grundlagen

Versionsnummer: Major,Minor,Patch

Major: Änderungen die das API brechen
Minor: Änderungen durch Hinzufügen neuer Features ohne Bruch der API
Patch: Änderungen zur Fehlerbehebung ohne Bruch der API

Als Alternative findet sich das [ Libtool versioning system](http://www.sourceware.org/autobook/autobook/autobook_91.html)

## Sicherstellung über TCK
[TCK](TCK.md): Technical Compatibility Kit

Eine Testsuite die sicherstellt, dass das API nicht gebrochen wurde.





