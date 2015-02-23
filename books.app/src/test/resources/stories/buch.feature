#language:de
Funktionalität: Bücherregal verwalten

  @modul
  Szenario: Ein neues Buch ohne ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Die Mutter" ohne ISBN hinzufüge.
    Dann enthält das Bücherregal 1 Bücher.

  @modul
  Szenario: Ein neues Buch mit gültiger ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Schwarz" und der ISBN "978-3-453-87556-2" hinzufüge.
    Dann enthält das Bücherregal 1 Buch mit gültiger ISBN.
  
  @modul
  Szenario: Ein neues Buch mit ungültiger ISBN hinzufügen.
    Gegeben sei ein leeres Bücherregal.
    Wenn ich ein Buch mit dem Titel "Schwarz" und der ISBN "978-3-453-87556-3" hinzufüge.
    Dann enthält das Bücherregal 1 Buch mit ungültiger ISBN.