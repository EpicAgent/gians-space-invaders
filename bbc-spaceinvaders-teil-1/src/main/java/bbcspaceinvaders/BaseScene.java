package bbcspaceinvaders;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseScene extends Scene {
    protected final Navigator NAVI;
    protected final Canvas CANVAS;

    public BaseScene(Navigator navigator, Image background) {
        super(new Group());
        NAVI = navigator;
        CANVAS = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        GraphicsContext gc = CANVAS.getGraphicsContext2D();
        gc.drawImage(background, 0, 0);
        Group root = (Group) getRoot();
        root.getChildren().add(CANVAS);
    }
}
