package spaceinvaders.game.gameobjects;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.game.Const;
import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.images.ImageType;
import spaceinvaders.game.Weapon;
import spaceinvaders.images.Images;
import spaceinvaders.sound.Sound;
import spaceinvaders.sound.SoundEffectType;

@Component
@Lazy
public class Spaceship extends GameObject {

    private final static double SPEED = 100;
    private final static double SHIP_Y = 480;
    private final static double LASER_SHOUT_INTERVAL = 1;

    private final KeyEventHandler keyEventHandler;
    private Weapon weapon;
    private Sound sound;
    private double shipBattery = 1;

    public Spaceship(KeyEventHandler keyEventHandler, Weapon weapon, Sound sound) {
        super(Const.SCREEN_WIDTH / 2, SHIP_Y, Images.load(ImageType.SPACESHIP));

        this.keyEventHandler = keyEventHandler;
        this.weapon = weapon;
        this.sound = sound;
    }

    @Override
    public void update(double deltaInSec) {
        handleNavigationEvents(deltaInSec);
        handleShootEvent(deltaInSec);
    }

    private void handleNavigationEvents(double deltaInSec) {

        double distanceToMove = SPEED * deltaInSec;

        if (keyEventHandler.isRightKeyPressed() && getX() < Const.SCREEN_WIDTH - getWidth())
            x += distanceToMove;
        if (keyEventHandler.isLeftKeyPressed() && getX() > 0)
            x -= distanceToMove;
    }

    private void handleShootEvent(double deltaInSec) {
        if (keyEventHandler.isSpaceKeyPressed() && shipBattery > LASER_SHOUT_INTERVAL) {
            weapon.fireLaser(this);
            sound.play(SoundEffectType.LASER_FIRED);
            shipBattery = 0;
        } else {
            shipBattery += deltaInSec;
        }
    }
}