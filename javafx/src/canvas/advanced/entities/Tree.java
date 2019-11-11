package canvas.advanced.entities;

import canvas.advanced.interfaces.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tree extends Entity implements Drawable {

    private Image treeImage;

    public Tree(double x, double y) {
        super(x, y);

        treeImage = new Image(getClass().getResourceAsStream("/assets_game/tree_small.png"));
    }

    public Tree() {
        this(0, 0);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(treeImage, x, y);
    }
}
