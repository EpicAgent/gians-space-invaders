# Gian's Space Invaders
Dieses Spiel wurde im Rahmen eines Schulprojektes in der 3. Sekundarschule im Schulhaus Gräfler, Schaffhausen, Schweiz entwickelt.
Die Idee war es, den Arcade-Game-Klassiker Space Invaders neu in Java zu programmieren.

![Mockups](Mockups.png)

## Autor
Gian Rohr, gian.rohr@gmx.ch, 3. Sekundarschule Schulhaus Gräfler, Schaffhausen, Schweiz 
## Spezial Features
- Musik und Soundeffekte

## Verwendete Frameworks
- Java SDK 21
- [JavaFX][fx] als Desktop UI-Framework
- Gradle als Build Tool

## Anforderung
800 x 600 resolution

## TODOs
- Mehr Level
- Score für Abschüsse
- Highscore

### Achitektur
![Classdiagram](Classdiagram.png)
Der JavaFX UI Code wurde zu grossen Teilen vom Gamecode entkoppelt.


### Installation
Der Code wurde mit Java SDK 21 und Java FX 16 getestet.
```sh
$ git clone https://github.com/EpicAgent/gians-space-invaders.git
$ java -jar \build\libs\gians-space-invaders-1.0-SNAPSHOT-all.jar
```
[//]: #
[fx]: <https://openjfx.io/>