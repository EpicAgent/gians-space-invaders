package bbcspaceinvaders.gameobjects;

import bbcspaceinvaders.Direction;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Alienship {

    private static final double SPEED = 100;
    private double x;
    private double y;
    private final Canvas canvas;
    private Image image = new Image(this.getClass().getResourceAsStream("/alienship.png"));
    private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y, Canvas canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void update(double deltaInSec) {
        moveInCurrentDirection(deltaInSec);
        changeDirectionIfNeeded();
    }

    private void moveInCurrentDirection(double deltaTimeInSec) {
        double distanceToMove = SPEED * deltaTimeInSec;
        if (direction == Direction.RIGHT) {
            x += distanceToMove;
        } else if (direction == Direction.LEFT) {
            x -= distanceToMove;
        }
    }

    private void changeDirectionIfNeeded() {
        if (x + image.getWidth() > canvas.getWidth()) {
            direction = Direction.LEFT;
        }
        if (x < 0) {
            direction = Direction.RIGHT;
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }
}
