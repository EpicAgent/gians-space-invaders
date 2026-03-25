package gianspaceinvaders.game.gameobjects;

import gianspaceinvaders.common.Config;
import gianspaceinvaders.game.GameObjects;
import gianspaceinvaders.game.Images;

public class Alienship extends GameObject {


    private final GameObjects gameObjects;
    private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y, GameObjects gameObjects) {
        super(x, y, Images.ALIEN_SHIP);
        this.gameObjects = gameObjects;
    }

    @Override
    public void update(double deltaInSec) {
        moveInCurrentDirection(deltaInSec);
        changeDirectionIfNeeded();
        dropBomb(deltaInSec);
    }

    private void dropBomb(double deltaInSec) {
        if (Math.random() < deltaInSec * Config.BOMB_DROP_CHANCE) {
            gameObjects.add(new Bomb(getBoundingBox().getCenterX(), getBoundingBox().getMaxY()));
        }
    }

    private void moveInCurrentDirection(double deltaTimeInSec) {
        double distanceToMove = Config.ALIENSHIP_SPEED * deltaTimeInSec;

        if (direction == Direction.RIGHT) {
            x += distanceToMove;
        } else if (direction == Direction.LEFT) {
            x -= distanceToMove;
        }
    }

    private void changeDirectionIfNeeded() {
        if (getX() + getImage().getWidth() > Config.SCREEN_WIDTH) {
            direction = Direction.LEFT;
        }
        if (getX() < 0) {
            direction = Direction.RIGHT;
        }
    }

}