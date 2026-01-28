package gianspaceinvaders.game;

import gianspaceinvaders.game.gameobjects.GameObject;
import gianspaceinvaders.game.gameobjects.Laser;
import gianspaceinvaders.game.gameobjects.Spaceship;

import java.util.List;

public class CollisionHandler {

    private final GameObjects gameObjects;

    public CollisionHandler(GameObjects gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void handle() {
        handleLaserAlienShipCollisions();
        handleLaserBombCollisions();
        handleBombSpaceShipCollisions();
    }

    private void handleLaserAlienShipCollisions() {
        for (Laser laser : gameObjects.getLasers()) {
            handleCollision(laser, gameObjects.getAlienShips());
        }
    }

    private void handleLaserBombCollisions() {
        for (Laser laser : gameObjects.getLasers()) {
            handleCollision(laser, gameObjects.getBombs());
        }
    }

    private void handleBombSpaceShipCollisions() {
        Spaceship spaceship = gameObjects.getSpaceShip();
        if (spaceship != null) {
            handleCollision(spaceship, gameObjects.getBombs());
        }
    }

    private void handleCollision(GameObject gameObject, List<? extends GameObject> gameObjects) {
        for (GameObject o : gameObjects) {
            if (o.collidesWith(gameObject)) {
                this.gameObjects.remove(o);
                this.gameObjects.remove(gameObject);
                return;
            }
        }
    }

}