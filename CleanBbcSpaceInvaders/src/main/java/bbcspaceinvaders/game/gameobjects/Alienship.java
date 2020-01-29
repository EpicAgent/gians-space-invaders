package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.game.Const;
import bbcspaceinvaders.game.Images;
import javafx.scene.canvas.GraphicsContext;

public class Alienship extends GameObject {

    public static final double SPEED = 100;
    public static final double BOMB_DROP_CHANCE = 0.2;
    private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y, Space space) {
        super(x, y, space, Images.ALIEN_SHIP);
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
    }

    @Override
    public void update(double deltaInSec) {
        moveInCurrentDirection(deltaInSec);
        changeDirectionIfNeeded();
        dropBomb(deltaInSec);
    }

    private void dropBomb(double deltaInSec) {
        if (Math.random() < deltaInSec * BOMB_DROP_CHANCE) {
            getSpace().add(new Bomb(getBoundingBox().getCenterX(), getBoundingBox().getMaxY(), getSpace()));
        }
    }

    private void moveInCurrentDirection(double deltaTimeInSec) {
        double distanceToMove = SPEED * deltaTimeInSec;

        if (direction == Direction.RIGHT) {
            x += distanceToMove;
        } else if (direction == Direction.LEFT) {
            x -= distanceToMove;
        }
    }

    private void changeDirectionIfNeeded() {
        if (getX() + getImage().getWidth() > Const.SCREEN_WIDTH) {
            direction = Direction.LEFT;
        }
        if (getX() < 0) {
            direction = Direction.RIGHT;
        }
    }
}