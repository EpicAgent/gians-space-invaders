package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.Direction;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public class Alienship {

    private static final double SPEED = 100;
    private double x;
    private double y;
    private final Canvas canvas;
    private List<Bomb> bombs;
    private Image image = new Image(this.getClass().getResourceAsStream("/alienship.png"));
    private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y, Canvas canvas, List<Bomb> bombs) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        this.bombs = bombs;
    }

    public void update(double deltaInSec) {
        changeDirectionIfNeeded();
        moveInCurrentDirection(deltaInSec);
        throwBombs();
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

    private void throwBombs() {
        if (Math.random() < 0.02) {
            bombs.add(new Bomb(this.getBoundingBox().getCenterX(), this.getBoundingBox().getMaxY()));
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(this.x, this.y, image.getWidth(), image.getHeight());
    }
}
