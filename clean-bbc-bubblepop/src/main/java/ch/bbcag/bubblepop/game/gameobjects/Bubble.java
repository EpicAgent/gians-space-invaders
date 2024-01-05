package ch.bbcag.bubblepop.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bubble extends GameObject {
    private final static double SPEED = 100;
    public static final double DIAMETER = 20;

    public Bubble(double x, double y) {
        super(x,y);
    }

    @Override
    public void update(double deltaInSec) {
        double distanceToMove = SPEED * deltaInSec;

        y += distanceToMove;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, getDiameter(), getDiameter());
    }

    public double getDiameter() {
        return DIAMETER;
    }
}
