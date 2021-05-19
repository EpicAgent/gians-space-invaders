package spaceinvaders.game.gameobjects;

import spaceinvaders.images.Images;
import spaceinvaders.game.Const;
import spaceinvaders.images.ImageType;
import spaceinvaders.game.Direction;
import spaceinvaders.game.Weapon;

public class Alien extends GameObject {

    private final static double SPEED = 100;
    private final static double BOMB_DROP_CHANCE = 0.2;

    private Weapon weapon;
    private Direction direction = Direction.RIGHT;

    public Alien(double x, double y, Weapon weapon) {
        super(x, y, Images.load(ImageType.ALIEN));
        this.weapon = weapon;
    }

    @Override
    public void update(double deltaInSec) {
        moveInCurrentDirection(deltaInSec);
        changeDirectionIfNeeded();
        dropBomb(deltaInSec);
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
        if (getX() + getWidth() > Const.SCREEN_WIDTH) {
            direction = Direction.LEFT;
        }

        if (getX() < 0) {
            direction = Direction.RIGHT;
        }
    }

    private void dropBomb(double deltaInSec) {
        if (Math.random() < deltaInSec * BOMB_DROP_CHANCE) {
            weapon.dropBomb(this);
        }
    }
}