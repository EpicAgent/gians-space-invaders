package racer2d;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.stage.Window;

public class Game extends Application {

    private GraphicsContext gc;
    private Image carImage;
    private Image treeImage;
    private double x = 350;
    private double y = 450;
    private Canvas canvas;
    private boolean inputRight;
    private boolean inputLeft;
    private long lastTime;
    private double carSpeed = 300;
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private static final int STREET_WIDTH = 300;
    private static final int LINE_WIDTH = 20;
    private static final double MAX_DELTA_TIME = 0.016;
    private static final Paint BACKGROUND = Paint.valueOf("#43CD7D");
    private static final Paint STREET = Paint.valueOf("#bbbbaa");
    private static final Paint LINE = Paint.valueOf("#ffffff");


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group rootGroup = new Group();
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        rootGroup.getChildren().add(canvas);
        rootGroup.setCache(true);
        rootGroup.setCacheHint(CacheHint.SPEED);
        gc = canvas.getGraphicsContext2D();

        primaryStage.setTitle("Racer 2D Game");
        Scene scene = new Scene(rootGroup);
        primaryStage.setScene(scene);
        load();

        scene.setOnKeyPressed((e) -> onKeyPressed(e));
        scene.setOnKeyReleased((e) -> onKeyReleased(e));

        lastTime = System.nanoTime();

        new AnimationTimer() {
            @Override
            public void handle(long currentTime) {
                update(currentTime);
                Platform.runLater(() -> paint());

            }
        }.start();



        primaryStage.show();
    }

    private void load() {
        carImage = new Image(getClass().getResourceAsStream("/game/car_blue.png"));
        treeImage = new Image(getClass().getResourceAsStream("/game/tree_small.png"));
    }

    private void paint() {
        // Background
        gc.setFill(BACKGROUND);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        //Street
        gc.setFill(STREET);
        gc.fillRect(250, 0, STREET_WIDTH, CANVAS_HEIGHT);

        //Line left
        gc.setFill(LINE);
        gc.fillRect(270, 0, LINE_WIDTH, CANVAS_HEIGHT);

        //Line right
        gc.setFill(LINE);
        gc.fillRect(510, 0, LINE_WIDTH, CANVAS_HEIGHT);

        gc.drawImage(carImage, x, y);

        gc.drawImage(treeImage, 150, 200);
        gc.drawImage(treeImage, 500, 100);

    }

    private void update(long currentTime) {
        double deltaTime = (currentTime - lastTime) /1e9d;
        if (deltaTime > MAX_DELTA_TIME) {
            deltaTime = MAX_DELTA_TIME;
        }
        lastTime = currentTime;
        if (inputLeft) {
            x -= carSpeed * deltaTime;
        }
        if (inputRight) {
            x += carSpeed * deltaTime;
        }
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            inputLeft = true;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            inputRight = true;
        }
    }

    private void onKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.LEFT) {
            inputLeft = false;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            inputRight = false;
        }
    }
}
