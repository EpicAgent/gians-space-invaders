package ch.bbcag.bbcspaceinvader.game.gameobjects;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bomb extends GameObject {

    public Bomb(double x, double y) {
    	super(x, y, 50, "Bomb.png");
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void update(double deltaTimeInSec) {
    	double distanceToMove = deltaTimeInSec * speed;
		y = y + distanceToMove;
    }
}
