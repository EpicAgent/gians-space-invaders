package ch.bbcag.gameobjects;

public class Bubble {
    private double x, y;
    private final double size = 20;

    public Bubble(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void update(double deltaInSec) {
        y += deltaInSec;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSize() {
        return size;
    }
}
