package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.game.Images;

public class Bomb extends GameObject {

    public static final double SPEED = 100;

    public Bomb(double x, double y, Space space) {
        super(x, y, space, Images.BOMB);
    }

    @Override
    public void update(double deltaInSec) {
        y += SPEED * deltaInSec;
    }
}
