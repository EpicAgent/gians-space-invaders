package spaceinvaders.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Factory;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.gameobjects.GameObject;
import spaceinvaders.game.gameobjects.Spaceship;

import java.util.ArrayList;
import java.util.List;

// Das Factory Interface ermöglich das Austauschen der GameObjekte für das Testing.
@Component
public class GameObjectFactory implements Factory {

    @Lazy
    @Autowired // TODO
    private Weapon weapon;

    @Lazy
    @Autowired // TODO
    private Spaceship spaceship;

    @Override
    public List<GameObject> create() {
        List<GameObject> gameObjects = new ArrayList<>();
        addAlienFleet(gameObjects);
        gameObjects.add(spaceship);
        return gameObjects;
    }

    private void addAlienFleet(List<GameObject> gameObjects) {
        gameObjects.add(new Alien(100, 20, weapon));
        gameObjects.add(new Alien(200, 20, weapon));
        gameObjects.add(new Alien(300, 20, weapon));
        gameObjects.add(new Alien(400, 20, weapon));
        gameObjects.add(new Alien(500, 20, weapon));
        gameObjects.add(new Alien(600, 20, weapon));
        gameObjects.add(new Alien(700, 20, weapon));
        gameObjects.add(new Alien(100, 120, weapon));
        gameObjects.add(new Alien(200, 120, weapon));
        gameObjects.add(new Alien(300, 120, weapon));
        gameObjects.add(new Alien(400, 120, weapon));
        gameObjects.add(new Alien(500, 120, weapon));
        gameObjects.add(new Alien(600, 120, weapon));
        gameObjects.add(new Alien(700, 120, weapon));
    }
}