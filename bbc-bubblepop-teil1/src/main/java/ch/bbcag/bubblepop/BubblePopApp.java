package ch.bbcag.bubblepop;

import ch.bbcag.gameobjects.Bubble;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubblePopApp extends Application {
    private Canvas canvas;
    private GraphicsContext gc;

    // Instanzvariable
    private long lastTimeInNanoSec;

    // Wir wollen das Paddel 150 Pixel in der Sekunde bewegen.
    private static final double SPEED = 150;
    private double paddleX = 200;
    private double paddleHeight = 20;
    private double paddleWidth = 100;
    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;
    private List<Bubble> bubbles = new CopyOnWriteArrayList<>();
    private Random random = new Random();
    private int score = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        lastTimeInNanoSec = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long currentTimeInNanoSec) {

                // currentTimeInNanoSec:
                // Der Wert entspricht der Anzahl vergangennen Nanosekunden
                // seit einem fixen Datum. (Meistens: 1.1.1970)

                long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
                double deltaInSec = deltaInNanoSec / 1000000000d; //oder: 1e9;

                lastTimeInNanoSec = currentTimeInNanoSec;

                update(deltaInSec);
                paint();
            }
        }.start();

        Group root = new Group();
        canvas = new Canvas(400, 600);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(root);

        scene.setOnKeyPressed((e) -> onKeyPressed(e));
        scene.setOnKeyReleased((e) -> onKeyReleased(e));

        stage.setTitle("BubblePop");
        stage.setScene(scene);
        stage.show();
    }

    private void update(double deltaInSec) {
        double distanceToMove = SPEED * deltaInSec;

        if (isLeftKeyPressed && paddleX > 0) {
            paddleX -= distanceToMove;
        }
        if (isRightKeyPressed && paddleX < canvas.getWidth() - 100) {
            paddleX += distanceToMove;
        }

        if (random.nextDouble() < 0.01) {
            bubbles.add(new Bubble(random.nextDouble() * (canvas.getWidth() - 20), 30));
        }

        for (Bubble bubble : bubbles) {
            bubble.update(deltaInSec);

            if (bubble.getY() >= canvas.getHeight() - paddleHeight - bubble.getDiameter() &&
                    bubble.getX() + bubble.getDiameter() >= paddleX &&
                    bubble.getX() <= paddleX + paddleWidth) {
                bubbles.remove(bubble);
                score++;
            } else if (bubble.getY() > canvas.getHeight()) {
                bubbles.remove(bubble);
            }

        }
    }

    private void paint() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.setFill(Color.WHITE);
        gc.fillRect(paddleX, 580, paddleWidth, paddleHeight);

        gc.setFill(Color.RED);
        for (Bubble bubble : bubbles) {
            gc.fillOval(bubble.getX(), bubble.getY(), bubble.getDiameter(), bubble.getDiameter());
        }

        gc.setFill(Color.WHITE);
        gc.setFont(new Font(20));
        gc.fillText("Score: " + score, 10, 20);
    }

    private void onKeyReleased(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                isLeftKeyPressed = false;
                break;
            case RIGHT:
                isRightKeyPressed = false;
                break;
        }
    }

    private void onKeyPressed(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                isLeftKeyPressed = true;
                break;
            case RIGHT:
                isRightKeyPressed = true;
                break;
        }
    }
}
