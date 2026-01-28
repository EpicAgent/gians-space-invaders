package bbcspaceinvaders.game.gameobjects;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
    protected final Image IMG;
    protected double x;
    protected double y;

    public GameObject(double x, double y, Image img) {
        IMG = img;
        this.x = x;
        this.y = y;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, IMG.getWidth(), IMG.getHeight());
    }

    public boolean collidesWith(GameObject otherGameObject) {
        return getBoundingBox().intersects(otherGameObject.getBoundingBox());
    }

    public abstract void update(double deltaInSec);

    public void draw(GraphicsContext gc) {
        gc.drawImage(IMG, x, y);
    }
}
