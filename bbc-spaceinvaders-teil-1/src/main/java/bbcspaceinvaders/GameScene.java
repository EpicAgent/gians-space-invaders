package bbcspaceinvaders;

import bbcspaceinvaders.game.gameobjects.Alienship;
import bbcspaceinvaders.game.gameobjects.GameObject;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameScene extends BaseScene {

    AnimationTimer gameLoop;
    List<GameObject> gameObjects = new CopyOnWriteArrayList<>();


    public GameScene(Navigator navigator) {
        super(navigator, Images.GAME);

        Alienship alien = new Alienship(300, 400);
        gameObjects.add(alien);


        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long l) {
             update(l);
             draw(CANVAS.getGraphicsContext2D());
            }
        };
        gameLoop.start();

    }

    public void update(double deltaInSec) {
        for (GameObject object : gameObjects) {
            object.update(deltaInSec);
        }

    }

    public void draw(GraphicsContext gc) {
        for (GameObject object : gameObjects) {
           object.draw(gc);
        }
    }
}
