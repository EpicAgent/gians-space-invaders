# language: de

Funktionalität: Als Spieler möchte ich den Gamescreen sehen.

  Szenario: Der Spieler kann mit der linken Pfeil Taste das Spaceship nach links schweben lassen.
    Angenommen die Spielfiguren sind maninipuliert und das Spiel kann nicht verloren oder gewonnen werden
    Und es existiert ein Spaceship bei X=400, Y=480
    Und der Spieler startet die Applikation
    Wenn der Spieler auf den Gamescreen gelangt
    Und der Spieler die linke Pfeil Taste drückt
    Und der Spieler 1 Sekunde wartet
    Dann befindet sich ein Spaceship bei X=500, Y=480

  Szenario: Der Spieler kann mit der rechten Pfeil Taste das Spaceship nach rechts schweben lassen.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn der Spieler die rechte Pfeil Taste drückt
    Dann schwebt das Spaceship mit einer Geschwindigkeit von 100 Pixel pro Sekunde nach rechts

  Szenario: Dem Spieler wird der Gameoverscreen angezeit, sobald sein Spaceship zerstört wird.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn das Spaceship zerstört wird
    Dann wird der Spieler zum Gamewonscreen weitergeleitet

  Szenario: Dem Spieler wird der Gamewonscreen angezeit, sobald alle Aliens zerstört sind.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn alle Aliens zerstört werden
    Dann wird der Spieler zum Gameoverscreen weitergeleitet

  Szenario: Dem Spieler wird das Spaceship angezeit.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn alle Aliens zerstört werden
    Dann wird der Spieler zum Gameoverscreen weitergeleitet

  Szenario: Das Spacehip kann das Fenster auf linken Seite nicht verlassen.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Angenommen das Spaceship befindet sich am linken Rand
    Wenn der Spieler die linke Pfeil Taste drückt
    Wenn der Spieler 1 Sekunde wartet
    Dann bleibt das Spaceship am linken Rand.

  Szenario: Das Spacehip kann das Fenster auf rechten Seite nicht verlassen.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Angenommen das Spaceship befindet sich am rechten Rand
    Wenn der Spieler die rechte Pfeil Taste drückt
    Wenn der Spieler 1 Sekunde wartet
    Dann bleibt das Spaceship am rechten Rand.

  Szenario: Dem Spieler wird das Spaceship angezeit.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Dann sieht der Spieler, dass 1 Spaceship angezeigt wird

  Szenariogrundriss: Das Spaceship ist korrekt plaziert.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Dann befindet sich ein Spaceship bei X="<X>", Y="<Y>"

    Beispiele:
      | X   | Y   |
      | 100 | 20  |

  Szenario: Mit der Space Taste kann der Spieler Laser abfeuern.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn der Spieler die Space Taste drückt
    Dann sieht der Spieler, dass 1 Laser angezeigt wird

  Szenario: Ein Laser schwebt mit 100 Pixel/Sekunde nach oben
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn der Spieler die Space Taste drückt
    Dann schwebt der Laser mit einer Geschwindigkeit von 100 Pixel pro Sekunde nach oben

  Szenario: Eine Laser zerstört ein Alien.
    Angenommen es existiert ein Spaceship
    Und es existiert ein Alien bei X=100, Y=100
    Und es existiert ein Laser bei X=100, Y=200
    Und der Spieler startet die Applikation
    Wenn der Spieler auf den Gamescreen gelangt
    Wenn der Spieler 2 Sekunde wartet
    Dann wird das Alien zerstört

  Szenario: Dem Spieler werden die 14 Aliens angezeit.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Dann sieht der Spieler, dass 14 Aliens angezeigt werden

  Szenariogrundriss: Die 14 Aliens sind korrekt plaziert.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Dann befindet sich ein Alien bei X="<X>", Y="<Y>"

  Beispiele:
  | X   | Y   |
  | 100 | 20  |
  | 200 | 20  |
  | 300 | 20  |
  | 400 | 20  |
  | 500 | 20  |
  | 600 | 20  |
  | 700 | 20  |
  | 100 | 120 |
  | 200 | 120 |
  | 300 | 120 |
  | 400 | 120 |
  | 500 | 120 |
  | 600 | 120 |
  | 700 | 120 |

  Szenario: Ein Alien schwebt nach dem Start automatisch mit 100 Pixel/Sekunde nach rechts.
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Und es existiert ein Spaceship
    Und es existiert ein Alien bei X=100, Y=100
    Und der Spieler gelangt auf den Gamescreen
    Wenn der Spieler 1 Sekunde wartet
    Dann es existiert ein Alien bei X=200, Y=100

  Szenario: Die Aliens werfen Bomben
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Wenn der Spieler 2 Sekunden wartet
    Dann sieht der Spieler, dass einige Bomben angezeigt werden

  Szenario: Eine Bombe schwebt mit 100 Pixel/Sekunde nach unten
    Angenommen der Spieler startet die Applikation
    Und der Spieler auf den Gamescreen gelangt
    Und es existiert eine Bombe bei X=100, Y=200
    Wenn der Spieler 1 Sekunden wartet
    Dann befindet sich eine Bombe bei X=200, Y=300

  Szenario: Eine Bombe (X=400/Y=380) ist 100 Pixel oberhalb des Spaceship (X=400/Y=480). Nach 2 Sekunden ist das Spaceship zerstört.
    Angenommen der Spieler startet die Applikation
    Und keine Aliens werden angezeigt
    Und das Spiel kann nicht verloren oder gewonnen werden
    Und das Spaceship ist auf der Startposition X=400, Y=480
    Und der Spieler gelangt auf den Gamescreen
    Und es existiert ein Bombe bei X=400, Y=380
    Wenn der Spieler 2 Sekunden wartet
    Dann wird das Spaceship zerstört