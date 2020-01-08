package bbcspaceinvaders.game;

import bbcspaceinvaders.game.gameobjects.Alienship;
import bbcspaceinvaders.game.gameobjects.Bomb;
import bbcspaceinvaders.game.gameobjects.Laser;
import bbcspaceinvaders.game.gameobjects.Spaceship;

public class CollisionHandler {

    private Space space;

    public CollisionHandler(Space space){
        this.space = space;
    }

    public void handle(){
            for (Laser laser : space.getLasers()) {
                for (Alienship alien : space.getAlienShips()) {
                    if (laser.collidesWith(alien)) {
                        space.remove(alien);
                        space.remove(laser);
                    }
                }
                for (Bomb bomb : space.getBombs()) {
                    if (laser.collidesWith(bomb)) {
                        space.remove(bomb);
                        space.remove(laser);
                    }
                }
            }

        Spaceship spaceship = space.getSpaceShip();
        if(spaceship != null){
            for (Bomb bomb : space.getBombs()) {
                if (spaceship.collidesWith(bomb)) {
                    space.remove(bomb);
                    space.remove(spaceship);
                    return;
                }
            }
        }

    }
}
