package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.main.Const;

public class Bomb extends GameObject {

    public Bomb(double x, double y, Space space){
        super(x, y, space, Const.BOMB_IMAGE);
    }

    @Override
    public void update(double deltaInSec) {
        y+=Const.SPEED_OF_BOMB * deltaInSec;

    }




}
