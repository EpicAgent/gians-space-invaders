package bbcspaceinvaders.common;

import bbcspaceinvaders.main.Const;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class GUIScene extends Scene {

    private Group group;
    protected final Navigator navigator;

    public GUIScene(Group group, Navigator navigator) {
        super(group);
        this.group = group;
        this.navigator = navigator;
        createGraphicsContext();
    }

    private GraphicsContext graphicsContext;

    public void onOpen(){}

    public void onClose(){}

    private GraphicsContext createGraphicsContext() {
        if(graphicsContext == null){
            Canvas canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
            group.getChildren().add(canvas);
            canvas.setCache(true);
            canvas.setCacheHint(CacheHint.SPEED);
            canvas.setDepthTest(DepthTest.ENABLE);
            graphicsContext = canvas.getGraphicsContext2D();
        }
        return graphicsContext;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
}
