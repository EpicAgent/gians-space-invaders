package spaceinvaders.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spaceinvaders.game.gameobjects.GameObject;
import spaceinvaders.game.gameobjects.Spaceship;
import java.util.List;

@Component
public class CollisionHandler {

    private GameObjects gameObjects;

    @Autowired
    public CollisionHandler(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void handle() {
        handleLaserAlienShipCollisions();
        handleLaserBombCollisions();
        handleBombSpaceShipCollisions();
    }

    private void handleLaserAlienShipCollisions() {
        gameObjects.getLasers().forEach(laser -> handleCollision(laser, gameObjects.getAlienShips()));
    }

    private void handleLaserBombCollisions() {
        gameObjects.getLasers().forEach(laser -> handleCollision(laser, gameObjects.getBombs()));
    }

    private void handleBombSpaceShipCollisions() {
        Spaceship spaceship = gameObjects.getSpaceShip();
        if (spaceship != null) {
            handleCollision(spaceship, gameObjects.getBombs());
        }
    }

    private void handleCollision(GameObject gameObject, List<? extends GameObject> gameObjectsToCheck) {

        for (GameObject o : gameObjectsToCheck) {
            if (o.collidesWith(gameObject)) {
                gameObjects.remove(o);
                gameObjects.remove(gameObject);
                return;
            }
        }
    }
}