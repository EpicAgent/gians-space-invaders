package spaceinvaders.game.gameobjects;

import spaceinvaders.images.Images;
import spaceinvaders.images.ImageType;

public class Laser extends GameObject {

    private final static double SPEED = 100;

    public Laser(double x, double y) {
        super(x, y, Images.load(ImageType.LASER));
    }

    @Override
    public void update(double deltaInSec) {
        y -= SPEED * deltaInSec;
    }
}
