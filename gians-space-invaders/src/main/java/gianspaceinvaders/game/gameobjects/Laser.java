package gianspaceinvaders.game.gameobjects;

import gianspaceinvaders.game.Images;

public class Laser extends GameObject {

    private final static double SPEED = 100;

    public Laser(double x, double y) {
        super(x, y, Images.LASER);
    }

    @Override
    public void update(double deltaInSec) {
        y -= SPEED * deltaInSec;
    }

}
