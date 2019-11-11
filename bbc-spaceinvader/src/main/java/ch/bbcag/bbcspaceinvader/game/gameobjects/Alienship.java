package ch.bbcag.bbcspaceinvader.game.gameobjects;

import ch.bbcag.bbcspaceinvader.game.Space;
import ch.bbcag.bbcspaceinvader.game.enums.EnumDirections;

public class Alienship extends GameObject {

	private static final double HORIZONTAL_BORDER_RIGHT = 690;
	private static final double HORIZONTAL_BORDER_LEFT = 10;
	private EnumDirections currentDirection = EnumDirections.RIGHT;
	private Space space;
	
    public Alienship(double x, double y, Space space) {
    	super(x, y, 50, "Alienship.png");
        this.x = x;
        this.y = y;
        this.space = space;
    }
	
	@Override
    public void update(double deltaTimeInSec) {
    	
    	if (isBatteryFull()) {
    		throwBomb();
    	}
    	
    	changeDirectionIfRequired();
    	moveInCurrentDirection(deltaTimeInSec);
    }
    
	private void throwBomb() {
		space.add(new Bomb(x + 50, 40));
	}
        
    private void moveInCurrentDirection(double deltaTimeInSec) {
		
    	double distanceToMove = deltaTimeInSec * speed;
    	
		if (currentDirection == EnumDirections.LEFT)
    		x = x - distanceToMove;
    	else
    		x = x + distanceToMove;
	}

	private void changeDirectionIfRequired() {
		
		if (x > HORIZONTAL_BORDER_RIGHT)
    		currentDirection = EnumDirections.LEFT;
    	
    	if (x < HORIZONTAL_BORDER_LEFT)
    		currentDirection = EnumDirections.RIGHT;
	}
		
	private boolean isBatteryFull() {
		return Math.random() < 0.002;
	}
}