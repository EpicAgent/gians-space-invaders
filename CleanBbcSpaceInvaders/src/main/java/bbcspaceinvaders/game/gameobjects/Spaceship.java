package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.KeyEventHandler;
import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.main.Const;

public class Spaceship extends GameObject {

    private KeyEventHandler keyEventHandler;
    private double shipBattery = 1;

    public Spaceship(KeyEventHandler keyEventHandler, Space space) {
        super(Const.SCREEN_WIDTH / 2, Const.SPACE_SHIP_Y, space, Const.SPACE_SHIP_IMAGE);
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public void update(double deltaInSec) {
        handleNavigationEvents(deltaInSec);
        handleShootEvent(deltaInSec);
    }

    private void handleNavigationEvents(double deltaInSec) {
        double distanceToMove = Const.SPEED_OF_SPACESHIP * deltaInSec;
        if(keyEventHandler.isRightKeyPressed() && getX() < Const.SCREEN_WIDTH - getImage().getWidth())
            x+=distanceToMove;
        if(keyEventHandler.isLeftKeyPressed() && getX() > 0)
            x-=distanceToMove;
    }

    private void handleShootEvent(double deltaInSec) {
        if(keyEventHandler.isSpaceKeyPressed() && shipBattery > Const.LASER_SHOUT_TIME){
            getSpace().add(new Laser(getX() + (getImage().getWidth() / 2), getY(), getSpace()));
            shipBattery = 0;
        } else {
            shipBattery += deltaInSec;
        }
    }


}
