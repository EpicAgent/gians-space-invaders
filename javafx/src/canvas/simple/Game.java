package canvas.simple;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Game extends Application {

    private GraphicsContext gc;
    private Image carImage;
    private Image treeImage;

    private long lastTime;

    private double x = 350;
    private double y = 450;

    private double carSpeed = 300;

    private boolean inputLeft = false;
    private boolean inputRight = false;

    private Canvas canvas;

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Racer2D");

        canvas = new Canvas(800, 600);
        canvas.setCache(true);
        canvas.setCacheHint(CacheHint.SPEED);

        gc = canvas.getGraphicsContext2D();

        load();

        scene.setOnKeyPressed((e) -> onKeyPressed(e));
        scene.setOnKeyReleased((e) -> onKeyReleased(e));

        lastTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                update(l);
            }
        }.start();

        root.getChildren().add(canvas);
        stage.show();
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
            inputLeft = true;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
            inputRight = true;
        }
    }

    private void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
            inputLeft = false;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
            inputRight = false;
        }
    }

    private void load() {
        carImage = new Image(getClass().getResourceAsStream("/assets_game/car_blue.png"));
        treeImage = new Image(getClass().getResourceAsStream("/assets_game/tree_small.png"));
    }

    private void paint() {

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Paint.valueOf("#43CD7D"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Paint.valueOf("#bbbbaa"));
        gc.fillRect(250, 0, 300, 600);
        gc.setFill(Paint.valueOf("#fff"));
        gc.fillRect(270, 0, 20, 600);
        gc.fillRect(510, 0, 20, 600);

        gc.drawImage(carImage, x, y);
        gc.drawImage(treeImage, 150, 200);
        gc.drawImage(treeImage, 500, 100);
    }

    private void update(long currentTime) {

        double deltaTime = (currentTime - lastTime) / 1e9;
        lastTime = currentTime;

        if (inputLeft) {
            x -= deltaTime * carSpeed;
        }
        if (inputRight) {
            x += deltaTime * carSpeed;
        }


        paint();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
