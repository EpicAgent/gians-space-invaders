package spaceinvaders.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Factory;
import spaceinvaders.common.Util;
import spaceinvaders.game.gameobjects.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class GameObjects extends CopyOnWriteArrayList<GameObject> {

    private Factory gameObjectFactory;

    @Autowired
    public GameObjects(Factory gameObjectFactory) { // Factory gameObjectFactory
        this.gameObjectFactory = gameObjectFactory;
    }

    public void initialize() {
        this.addAll(gameObjectFactory.create());
    }

    public Spaceship getSpaceShip() {
        return Util.getAllObjectsFromType(Spaceship.class, this).stream().findAny().orElse(null);
    }

    public List<Alien> getAlienShips() {
        return Util.getAllObjectsFromType(Alien.class, this);
    }

    public List<Bomb> getBombs() {
        return Util.getAllObjectsFromType(Bomb.class, this);
    }

    public List<Laser> getLasers() {
        return Util.getAllObjectsFromType(Laser.class, this);
    }
}