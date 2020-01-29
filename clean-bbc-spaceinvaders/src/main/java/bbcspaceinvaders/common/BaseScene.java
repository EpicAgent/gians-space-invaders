package bbcspaceinvaders.common;

import bbcspaceinvaders.game.Const;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class BaseScene extends Scene {

    protected final Navigator navigator;

    public BaseScene(Navigator navigator, Group group) {
        super(group);
        this.navigator = navigator;
    }

    public BaseScene(Navigator navigator, Group group, Image backgroundImage) {
        this(navigator, group);
        drawBackgroundImage(backgroundImage, group);
    }

    protected GraphicsContext createGraphicsContext(Group group){
        Canvas canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        group.getChildren().add(canvas);
        return canvas.getGraphicsContext2D();
    }

    private void drawBackgroundImage(Image backgroundImage, Group group){
        GraphicsContext gc = createGraphicsContext(group);
        gc.drawImage(backgroundImage, 0, 0);
    }
}
