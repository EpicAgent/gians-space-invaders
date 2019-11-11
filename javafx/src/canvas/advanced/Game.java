package canvas.advanced;

import canvas.advanced.entities.Car;
import canvas.advanced.entities.Road;
import canvas.advanced.entities.Tree;
import canvas.advanced.interfaces.Drawable;
import canvas.advanced.interfaces.Updateable;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Game extends Application {

    private Canvas canvas;
    private GraphicsContext gc;

    private ArrayList<Updateable> updateables;
    private ArrayList<Drawable> drawables;

    private long lastTime;

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Graphics2D");

        scene.setOnKeyPressed(Input.getInstance());
        scene.setOnKeyReleased(Input.getInstance());

        canvas = new Canvas(800, 600);
        canvas.setCache(true);
        canvas.setCacheHint(CacheHint.SPEED);
        canvas.setDepthTest(DepthTest.ENABLE);

        gc = canvas.getGraphicsContext2D();

        drawables = new ArrayList<>();
        updateables = new ArrayList<>();

        load();

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

    private void load() {

        Road road = new Road(250, 0, 300, 600);
        Car car = new Car(350, 450);
        Tree treeLeft = new Tree(150, 200);
        Tree treeRight = new Tree(500, 100);

        drawables.add(road);
        drawables.add(car);
        drawables.add(treeLeft);
        drawables.add(treeRight);
        updateables.add(car);

    }

    private void paint() {

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Draw green background
        gc.setFill(Paint.valueOf("#43CD7D"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Drawable drawable : drawables) {
            drawable.draw(gc);
        }
    }

    private void update(long currentTime) {

        double deltaTime = (currentTime - lastTime) / 1e9;
        lastTime = currentTime;

        for (Updateable updateable : updateables) {
            updateable.update(deltaTime);
        }

        paint();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
