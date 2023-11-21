package ch.bbcag.bubblepop.game.gameobjects;

import ch.bbcag.bubblepop.game.KeyEventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static ch.bbcag.bubblepop.Const.*;

public class Paddle extends GameObject {
    private final KeyEventHandler keyEventHandler;
    public double speed = 100;

    public Paddle(double x, double y, KeyEventHandler keyEventHandler) {
        super(x,y);
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    @Override
    public void update(double deltaInSec) {
        handleNavigationEvents(deltaInSec);
    }

    private void handleNavigationEvents(double deltaInSec) {
        double distanceToMove = speed * deltaInSec;

        if (keyEventHandler.isLeftKeyPressed() && x > 0) {
            x -= distanceToMove;
        }
        if (keyEventHandler.isRightKeyPressed() && x < SCREEN_WIDTH - PADDLE_WIDTH) {
            x += distanceToMove;
        }
    }
}
