package ch.bbcag.bbcspaceinvader.game.gameobjects;

import ch.bbcag.bbcspaceinvader.game.Const;
import ch.bbcag.bbcspaceinvader.game.KeyEventHandler;
import ch.bbcag.bbcspaceinvader.game.Space;


public class Spaceship extends GameObject {

	private static final double MAX_BATTERY_POWER = 5; // After 5 sec. you reach max-power
	private static final double BATTERY_POWER_FOR_ONE_SHOT = 1;
		
	private KeyEventHandler keyEventHandler;
	private Space space;
	private double currentBatteryPower = 0;

	public Spaceship(Space space, KeyEventHandler keyEventHandler) {
		super(350, 430, 100, "Spaceship.png");
		this.keyEventHandler = keyEventHandler;
	    this.space = space;
	}
	
	@Override
	public void update(double deltaTime) {
		handleNavigationEvents(deltaTime);
    	chargeBattery(deltaTime);
		handleShootEvent();
	}
	
    private void handleShootEvent() {
        if (keyEventHandler.isSpaceKeyPressed() && currentBatteryPower > BATTERY_POWER_FOR_ONE_SHOT) {
        	currentBatteryPower = currentBatteryPower - BATTERY_POWER_FOR_ONE_SHOT;
        	createLaserShot();
        }
    }

	private void handleNavigationEvents(double deltaInSec) {
		double distanceToMove = speed * deltaInSec;
		if (keyEventHandler.isLeftKeyPressed() && x > 0)
			x = x - distanceToMove;

		if (keyEventHandler.isRightKeyPressed() && x < Const.SCREEN_WIDTH - Const.SPACESHIP_WIDTH)
			x = x + distanceToMove;
	}

    private void chargeBattery(double deltaTime) {
    	if (currentBatteryPower < MAX_BATTERY_POWER) {
    		currentBatteryPower = currentBatteryPower + deltaTime;
    	}
    }

    private void createLaserShot() {
    	space.add(new Laser(x + getBoundingBox().getWidth()/2, y - 20));
    }
}
