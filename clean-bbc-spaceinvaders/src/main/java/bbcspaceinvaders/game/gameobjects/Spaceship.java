package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.*;

public class Spaceship extends GameObject {

    public static final double SPEED = 100;
    public static final double SHIP_Y = 480;
    public static final double LASER_SHOUT_TIME = 1;
    private KeyEventHandler keyEventHandler;
    private double shipBattery = 1;

    public Spaceship(KeyEventHandler keyEventHandler, Space space) {
        super(Const.SCREEN_WIDTH / 2, SHIP_Y, space, Images.SPACE_SHIP);
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public void update(double deltaInSec) {
        handleNavigationEvents(deltaInSec);
        handleShootEvent(deltaInSec);
    }

    private void handleNavigationEvents(double deltaInSec) {

        double distanceToMove = SPEED * deltaInSec;

        if (keyEventHandler.isRightKeyPressed() && getX() < Const.SCREEN_WIDTH - getImage().getWidth())
            x += distanceToMove;
        if (keyEventHandler.isLeftKeyPressed() && getX() > 0)
            x -= distanceToMove;
    }

    private void handleShootEvent(double deltaInSec) {
        if (keyEventHandler.isSpaceKeyPressed() && shipBattery > LASER_SHOUT_TIME) {
            getSpace().add(new Laser(getX() + (getImage().getWidth() / 2), getY(), getSpace()));
            Sound.play(SoundEffectType.LASER_FIRED);
            shipBattery = 0;
        } else {
            shipBattery += deltaInSec;
        }
    }
}