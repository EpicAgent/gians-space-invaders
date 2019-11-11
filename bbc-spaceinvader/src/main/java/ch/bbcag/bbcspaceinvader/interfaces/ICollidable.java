package ch.bbcag.bbcspaceinvader.interfaces;

import javafx.geometry.BoundingBox;

public interface ICollidable {
	boolean collidesWith(ICollidable other);
	BoundingBox getBoundingBox();
}
