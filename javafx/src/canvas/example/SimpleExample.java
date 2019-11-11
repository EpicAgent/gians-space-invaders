package canvas.example;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SimpleExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Group group = new Group();
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Paint.valueOf("#cc0000"));
        gc.fillOval(50, 60, 300, 290);

        gc.setFill(Paint.valueOf("#ff0000"));
        gc.fillOval(50, 40, 300, 290);

        gc.setFill(Paint.valueOf("#fff"));
        gc.setFont(Font.font("Verdana", 72));
        gc.fillText("Don't\nPush", 110, 180);


        group.getChildren().add(canvas);
        stage.setTitle("Canvas - SimpleExample");
        stage.setScene(new Scene(group));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
