package ch.bbcag.bbcspaceinvader.game.gameobjects;

import ch.bbcag.bbcspaceinvader.interfaces.ICollidable;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class GameObject implements ICollidable {

	protected double x;
	protected double y;
	protected double speed;
	protected Image image;

	public GameObject(double x, double y, double speed, String imageName) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.image = new Image(this.getClass().getResourceAsStream("/" + imageName));
	}

	public void draw(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

	public abstract void update(double deltaTimeInSec);

	public BoundingBox getBoundingBox() {
		return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
	}
	
	public boolean collidesWith(ICollidable other) {
		return this.getBoundingBox().intersects(other.getBoundingBox());
	}
}