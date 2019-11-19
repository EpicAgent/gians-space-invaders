package rectangleanimate;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {

    private Rectangle rectangle = new Rectangle(100, 100, 100, 100);
    private long lastTimeInNano;
    private static final int SPEED = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rectangle.setFill(Paint.valueOf("#000000"));
        rectangle.setCache(true);
        rectangle.setCacheHint(CacheHint.SPEED);
        lastTimeInNano = System.nanoTime();
        Pane rootPane = new Pane();
        rootPane.getChildren().add(rectangle);
        Scene scene = new Scene(rootPane, 800,600);
        primaryStage.setScene(scene);

        new AnimationTimer() {
            @Override
            public void handle(long nowInNano) {
                double deltaTimeInSeconds = (nowInNano - lastTimeInNano) / 1e9d;
                rectangle.setX(rectangle.getX() + (SPEED * deltaTimeInSeconds));
                lastTimeInNano = nowInNano;
            }
        }.start();

        primaryStage.show();
    }
}
