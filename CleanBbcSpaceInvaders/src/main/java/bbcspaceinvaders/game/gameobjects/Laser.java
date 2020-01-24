package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.main.Images;

public class Laser extends GameObject {

    public static final double SPEED = 100;

    public Laser(double x, double y, Space space) {
        super(x, y, space, Images.LASER_IMAGE);
    }

    @Override
    public void update(double deltaInSec) {
        y -= SPEED * deltaInSec;
    }
}
