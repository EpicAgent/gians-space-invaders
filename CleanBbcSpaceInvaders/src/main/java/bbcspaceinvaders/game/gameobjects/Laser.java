package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.main.Const;

public class Laser extends GameObject {

    public Laser(double x, double y, Space space){
        super(x, y, space, Const.LASER_IMAGE);
    }

    @Override
    public void update(double deltaInSec) {
        y-=Const.SPEED_OF_LASER * deltaInSec;
    }

}
