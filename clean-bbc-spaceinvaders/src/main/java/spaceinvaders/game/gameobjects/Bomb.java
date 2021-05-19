package spaceinvaders.game.gameobjects;

import spaceinvaders.images.Images;
import spaceinvaders.images.ImageType;

public class Bomb extends GameObject {

    private final static double SPEED = 100;

    public Bomb(double x, double y) {
        super(x, y, Images.load(ImageType.BOMB));
    }

    @Override
    public void update(double deltaInSec) {
        y += SPEED * deltaInSec;
    }
}
