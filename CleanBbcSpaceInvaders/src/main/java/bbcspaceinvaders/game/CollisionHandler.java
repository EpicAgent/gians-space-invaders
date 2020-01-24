package bbcspaceinvaders.game;

import bbcspaceinvaders.game.gameobjects.GameObject;
import bbcspaceinvaders.game.gameobjects.Laser;
import bbcspaceinvaders.game.gameobjects.Spaceship;

import java.util.List;

public class CollisionHandler {

    private Space space;

    public CollisionHandler(Space space) {
        this.space = space;
    }

    public void handle() {
        handleLaserAlienShipCollisions();
        handleLaserBombCollisions();
        handleBombSpaceShipCollisions();
    }

    private void handleLaserAlienShipCollisions() {
        for (Laser laser : space.getLasers()) {
            handleCollision(laser, space.getAlienShips());
        }
    }

    private void handleLaserBombCollisions() {
        for (Laser laser : space.getLasers()) {
            handleCollision(laser, space.getBombs());
        }
    }

    private void handleBombSpaceShipCollisions() {
        Spaceship spaceship = space.getSpaceShip();
        if (spaceship != null) {
            handleCollision(spaceship, space.getBombs());
        }
    }

    private void handleCollision(GameObject gameObject, List<? extends GameObject> gameObjects) {
        for (GameObject o : gameObjects) {
            if (o.collidesWith(gameObject)) {
                space.remove(o);
                space.remove(gameObject);
                return;
            }
        }
    }
}