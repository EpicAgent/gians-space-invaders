package gianspaceinvaders.game;

import gianspaceinvaders.common.Navigator;
import gianspaceinvaders.game.gameobjects.Alienship;
import gianspaceinvaders.game.gameobjects.GameObject;
import gianspaceinvaders.game.gameobjects.Spaceship;
import gianspaceinvaders.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;

public class Space {

    private final KeyEventHandler keyEventHandler;
    private final Navigator<SceneType> navigator;
    private final Runnable gameLoopStopper;
    private final GameObjects gameObjects;

    private final CollisionHandler collisionHandler;

    public Space(KeyEventHandler keyEventHandler, Navigator<SceneType> navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.navigator = navigator;
        this.gameLoopStopper = gameLoopStopper;
        this.gameObjects = new GameObjects();
        this.collisionHandler = new CollisionHandler(gameObjects);
    }

    public void load() {
        gameObjects.add(new Spaceship(keyEventHandler, gameObjects));
        for (int y = 20; y <= 120; y += 100) {
            for (int x = 100; x <= 700; x += 100) {
                gameObjects.add(new Alienship(x, y, gameObjects));
            }
        }
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.drawImage(Images.GAME_BACKGROUND, 0, 0);
        for (GameObject object : gameObjects) {
            object.draw(gc);
        }
    }

    public void update(double deltaInSec) {
        for (GameObject object : gameObjects) {
            object.update(deltaInSec);
        }
        collisionHandler.handle();
        if (!gameObjects.hasSpaceShip()) {
            navigator.goTo(SceneType.GAME_OVER);
            stop();
        } else if (gameObjects.getAlienShips().isEmpty()) {
            navigator.goTo(SceneType.GAME_WON);
            stop();
        }
    }

    private void stop() {
        gameLoopStopper.run();
        gameObjects.clear();
    }

}