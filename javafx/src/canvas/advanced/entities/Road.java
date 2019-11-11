package canvas.advanced.entities;

import canvas.advanced.interfaces.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Road extends Entity implements Drawable {

    private double width = 0;
    private double height = 0;

    private double lineWidth = 0;

    public Road(double x, double y, double width, double height) {
        super(x, y);

        this.width = width;
        this.height = height;

        this.lineWidth = width / 15;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Paint.valueOf("#bbbbaa"));
        gc.fillRect(x, y, width, height);

        gc.setFill(Paint.valueOf("#fff"));
        gc.fillRect(x + lineWidth, y, lineWidth, height);
        gc.fillRect(x + width - (lineWidth * 2), y, lineWidth, y + height);
    }
}
