package bbcspaceinvaders.common;

import bbcspaceinvaders.main.Const;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class GUIScene extends Scene {

    protected final Navigator navigator;
    private final Group group;
    private GraphicsContext graphicsContext;

    public GUIScene(Group group, Navigator navigator) {
        super(group);
        this.group = group;
        this.navigator = navigator;
        createGraphicsContext();
    }

    public void onOpen() {
    }

    public void onClose() {
    }

    private GraphicsContext createGraphicsContext() {
        Canvas canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        group.getChildren().add(canvas);
        canvas.setCache(true);
        canvas.setCacheHint(CacheHint.SPEED);
        canvas.setDepthTest(DepthTest.ENABLE);
        graphicsContext = canvas.getGraphicsContext2D();

        return graphicsContext;
    }

    protected GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
