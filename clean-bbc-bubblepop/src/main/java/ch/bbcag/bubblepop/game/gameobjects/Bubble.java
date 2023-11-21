package ch.bbcag.bubblepop.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble extends GameObject {
    private final static double speed = 100;
    private final double size = 20;

    public Bubble(double x, double y) {
        super(x,y);
    }

    @Override
    public void update(double deltaInSec) {
        double distanceToMove = speed * deltaInSec;

        y += distanceToMove;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, size, size);
    }

    public double getSize() {
        return size;
    }
}
