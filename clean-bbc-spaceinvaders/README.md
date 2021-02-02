# BBC SpaceInvaders
Dies ist die Muster Inplementierung des offiziellen Bbc SpaceInvader Tutorials.
Der Code zeigt die Verwendung der wichtigsten OOP Konzepe (Kapselung / Vererbung / Polymorphismus) und bietet eine Grundlage für viele andere Arcade-Games.

## Spezial Features
- Musik und Soundeffekte

## Verwendete Frameworks
- Java SDK 13
- [JavaFX][fx] als Desktop UI-Framework
- Gradle als Build Tool

### Achitektur
![Image of Yaktocat](Classdiagram.png)
Der JavaFX UI Code wurde zu grossen Teilen vom Gamecode entkoppelt.

### TODO's
Der Business Code im Order Game sollte keine Abhängigkeiten zu Java FX Packages enthalten.

### Installation
Der Code wurde mit Java SDK 13 und Java FX 12.0.1 getestet.
```sh
$ git clone https:/.../clean-bbc-spaceinvaders.git
$ java -jar \build\lib\clean-bbc-spaceinvaders-1.0-SNAPSHOT.jar)
```
[//]: #
[fx]: <https://openjfx.io/>