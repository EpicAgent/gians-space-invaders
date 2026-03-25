package gianspaceinvaders.game.gameobjects;

import gianspaceinvaders.common.Config;
import gianspaceinvaders.game.Images;

public class Laser extends GameObject {

    public Laser(double x, double y) {
        super(x, y, Images.LASER);
    }

    @Override
    public void update(double deltaInSec) {
        y -= Config.LASER_SPEED * deltaInSec;
    }

}
