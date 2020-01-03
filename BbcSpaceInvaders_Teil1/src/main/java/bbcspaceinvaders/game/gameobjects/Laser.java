package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.Direction;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Laser {

    private static final double SPEED = 100;
    private double x;
    private double y;
    private Image image = new Image(this.getClass().getResourceAsStream("/projectile.png"));
    private Direction direction = Direction.RIGHT;

    public Laser(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double deltaInSec) {
        double distanceToMove = SPEED * deltaInSec;
        y -= distanceToMove;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }

    public boolean collidesWith(Alienship alien) {
        return this.getBoundingBox().intersects(alien.getBoundingBox());
    }

    public boolean collidesWith(Bomb bomb) {
        return this.getBoundingBox().intersects(bomb.getBoundingBox());
    }
}
