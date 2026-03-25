package gianspaceinvaders.game.gameobjects;

import gianspaceinvaders.common.Config;
import gianspaceinvaders.game.Images;

public class Bomb extends GameObject {


    public Bomb(double x, double y) {
        super(x, y, Images.BOMB);
    }

    @Override
    public void update(double deltaInSec) {
        y += Config.BOMB_SPEED * deltaInSec;
    }

}
