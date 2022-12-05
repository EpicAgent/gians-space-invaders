package bbcspaceinvaders;

import bbcspaceinvaders.game.gameobjects.Alienship;
import bbcspaceinvaders.game.gameobjects.Bomb;
import bbcspaceinvaders.game.gameobjects.Laser;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BbcSpaceInvadersApp extends Application {

    private Canvas canvas;
    private GraphicsContext gc;
    private Image spaceshipImage = new Image(this.getClass().getResourceAsStream("/spaceship.png"));
    private Image backgroundImage = new Image(this.getClass().getResourceAsStream("/background_game.png"));
    private static final double SPEED_OF_SPACESHIP = 100;
    private double spaceshipPosX = 370;
    private long lastTimeInNanoSec;
    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;
    private boolean isSpaceKeyPressed = false;
    private List<Alienship> alienFleet = new CopyOnWriteArrayList<>();
    private List<Bomb> bombs = new CopyOnWriteArrayList<>();
    private List<Laser> laserShots = new ArrayList<>();
    private double laserPower = 1.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  {

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
        canvas = new Canvas(800, 600);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();
        stage.setTitle("Bbc SpaceInvaders");

        alienFleet.add(new Alienship(100, 40, canvas, bombs));
        alienFleet.add(new Alienship(200, 40, canvas, bombs));

        Scene scene = new Scene(root);
        stage.setScene(scene);

        scene.setOnKeyPressed((e) -> onKeyPressed(e));
        scene.setOnKeyReleased((e) -> onKeyReleased(e));

        stage.show();
    }

    private void onKeyReleased(KeyEvent e) {
        if (e.getCode() == KeyCode.LEFT) {
            isLeftKeyPressed = false;
        }
        if (e.getCode() == KeyCode.RIGHT) {
            isRightKeyPressed = false;
        }
        if (e.getCode() == KeyCode.SPACE) {
            isSpaceKeyPressed = false;
        }
    }

    private void onKeyPressed(KeyEvent e) {
        if (e.getCode() == KeyCode.LEFT) {
            isLeftKeyPressed = true;
        }
        if (e.getCode() == KeyCode.RIGHT) {
            isRightKeyPressed = true;
        }
        if (e.getCode() == KeyCode.SPACE) {
            isSpaceKeyPressed = true;
        }
    }

    private void paint() {
        gc.drawImage(backgroundImage, 0, 0);
        gc.drawImage(spaceshipImage, spaceshipPosX, 400);

        for (Alienship alienship : alienFleet) {
            alienship.draw(gc);
        }
        for (Laser laser : laserShots) {
            laser.draw(gc);
        }
        for (Bomb bomb : bombs) {
            bomb.draw(gc);
        }
    }

    private void update(double deltaInSec) {
        if (isRightKeyPressed && spaceshipPosX < 800 - 58) {
            double distanceToMove = SPEED_OF_SPACESHIP * deltaInSec;
            spaceshipPosX = spaceshipPosX + distanceToMove;
        }

        if (isLeftKeyPressed && spaceshipPosX > 0) {
            double distanceToMove = SPEED_OF_SPACESHIP * deltaInSec;
            spaceshipPosX = spaceshipPosX - distanceToMove;
        }

        for (Alienship alienship : alienFleet) {
            alienship.update(deltaInSec);
        }
        for (Laser laser : laserShots) {
            laser.update(deltaInSec);
        }
        for (Bomb bomb : bombs) {
            bomb.update(deltaInSec);
        }

        laserPower += deltaInSec;
        if (isSpaceKeyPressed && laserPower > 1){
            laserShots.add(new Laser(spaceshipPosX + spaceshipImage.getWidth() / 2, 380));
            laserPower -= 1;
        }

        for (Laser shot : laserShots) {
            for (Alienship alien : alienFleet) {
                if (shot.collidesWith(alien)) {
                    alienFleet.remove(alien);
                }
            }
            for (Bomb bomb : bombs) {
                if (shot.collidesWith(bomb)) {
                    bombs.remove(bomb);
                }
            }
        }
    }
}