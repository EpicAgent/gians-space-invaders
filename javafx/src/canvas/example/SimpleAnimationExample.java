package canvas.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SimpleAnimationExample extends Application {


    private double x = 190;
    private double y = 190;
    private double angle = 0;
    private long time = 0;

    @Override
    public void start(Stage stage) throws Exception {

        Group group = new Group();
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        time = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long actualTime) {
                double delta = (actualTime - time) / 1e9;
                time = actualTime;

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                gc.translate(x, y);
                gc.rotate(angle);
                gc.setFill(Paint.valueOf("#00cc00"));
                gc.fillOval(90, 0, 20, 20);
                gc.rotate(-angle);
                gc.translate(-x, -y);

                angle += 180 * delta;

            }
        }.start();


        group.getChildren().add(canvas);
        stage.setTitle("Canvas - SimpleExample");
        stage.setScene(new Scene(group));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
