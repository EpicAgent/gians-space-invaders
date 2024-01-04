package ch.bbcag.gameobjects;

public class Bubble {
    private double x, y;
    private final double DIAMETER = 20;
    private static final double SPEED = 100;

    public Bubble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double deltaInSec) {
        double distanceToMove = SPEED * deltaInSec;
        y += distanceToMove;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDiameter() {
        return DIAMETER;
    }
}
