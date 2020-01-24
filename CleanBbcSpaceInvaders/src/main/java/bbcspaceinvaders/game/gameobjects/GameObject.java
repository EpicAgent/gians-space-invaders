package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.game.Space;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {

    protected double x;
    protected double y;
    private Space space;
    private Image image;

    public GameObject(double x, double y, Space space, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.space = space;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    protected BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }

    public boolean collidesWith(GameObject e) {
        return getBoundingBox().intersects(e.getBoundingBox());
    }

    public void update(double deltaInSec) {
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    protected Space getSpace() {
        return space;
    }
}
