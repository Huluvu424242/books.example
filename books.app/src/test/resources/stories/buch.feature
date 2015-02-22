#language:de
Funktionalität: Bücherregal verwalten

  Szenario: Ein neues Buch ohne ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Die Mutter" ohne ISBN hinzufüge.
    Dann enthält das Bücherregal 1 Bücher.

  Szenario: Ein neues Buch mit ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Schwarz" und der ISBN "978-3-453-87556-2" hinzufüge.
    Dann enthält das Bücherregal 1 Buch mit gültiger ISBN.
  
  Szenario: Ein neues Buch mit ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Schwarz" und der ISBN "978-3-453-87556-3" hinzufüge.
    Dann enthält das Bücherregal 1 Buch mit ungültiger ISBN.