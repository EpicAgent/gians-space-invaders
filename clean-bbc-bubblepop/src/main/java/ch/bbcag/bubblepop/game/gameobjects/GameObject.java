package ch.bbcag.bubblepop.game.gameobjects;

import javafx.scene.canvas.GraphicsContext;
public abstract class GameObject {

    protected double x;
    protected double y;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update(double deltaInSec);

    public abstract void draw(GraphicsContext gc);


    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
