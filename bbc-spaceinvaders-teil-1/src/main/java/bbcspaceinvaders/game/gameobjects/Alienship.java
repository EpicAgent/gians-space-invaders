package bbcspaceinvaders.game.gameobjects;

import bbcspaceinvaders.Const;
import bbcspaceinvaders.Direction;
import bbcspaceinvaders.Images;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public class Alienship extends GameObject {

    private static final double SPEED = 100;
        private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y) {
        super(x, y, Images.ALIEN);
    }

    public void update(double deltaInSec) {
        changeDirectionIfNeeded();
        moveInCurrentDirection(deltaInSec);
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
        if (x + IMG.getWidth() > Const.SCREEN_WIDTH) {
            direction = Direction.LEFT;
        }
        if (x < 0) {
            direction = Direction.RIGHT;
        }
    }






}
