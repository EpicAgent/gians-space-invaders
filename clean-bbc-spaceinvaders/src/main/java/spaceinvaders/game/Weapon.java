package spaceinvaders.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.game.gameobjects.*;

@Component
@Lazy
public class Weapon {

    private GameObjects gameObjects;

    @Autowired
    public Weapon(GameObjects gameObjects){
        this.gameObjects = gameObjects;
    }

    public void fireLaser(GameObject spaceship) {
        gameObjects.add(new Laser(spaceship.getX() + (spaceship.getWidth() / 2), spaceship.getY()));
    }

    public void dropBomb(GameObject alien) {
        gameObjects.add(new Bomb(alien.getBoundingBox().getCenterX(), alien.getBoundingBox().getMaxY()));
    }
}
