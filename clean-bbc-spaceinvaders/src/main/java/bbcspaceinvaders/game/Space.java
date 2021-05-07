package bbcspaceinvaders.game;

import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.common.Util;
import bbcspaceinvaders.game.gameobjects.*;
import bbcspaceinvaders.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Space extends CopyOnWriteArrayList<GameObject> {

    private final KeyEventHandler keyEventHandler;
    private final Runnable gameLoopStopper;
    private final Navigator navigator;

    private final CollisionHandler collisionHandler;

    public Space(KeyEventHandler keyEventHandler, Navigator navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.gameLoopStopper = gameLoopStopper;
        this.collisionHandler = new CollisionHandler(this);
        this.navigator = navigator;
    }

    public void load() {
        add(new Spaceship(keyEventHandler, this));
        for (int y = 20; y <= 120 ; y+= 100) {
            for (int x = 100; x <= 700; x+= 100) {
                add(new Alienship(x, y, this));
            }
        }
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        gc.drawImage(Images.GAME_BACKGROUND, 0, 0);
        for (GameObject object : this) {
            object.draw(gc);
        }
    }

    public void update(double deltaInSec) {
        for (GameObject object : this) {
            object.update(deltaInSec);
        }
        collisionHandler.handle();

        if (Util.getAllObjectsFromType(Spaceship.class, this).isEmpty()) {
            navigator.goTo(SceneType.GAME_OVER);
            stop();
        } else if (getAlienShips().isEmpty()) {
            navigator.goTo(SceneType.GAME_WON);
            stop();
        }
    }

    public Spaceship getSpaceShip() {
        return Util.getAllObjectsFromType(Spaceship.class, this).get(0);
    }

    public List<Alienship> getAlienShips() {
        return Util.getAllObjectsFromType(Alienship.class, this);
    }

    public List<Bomb> getBombs() {
        return Util.getAllObjectsFromType(Bomb.class, this);
    }

    public List<Laser> getLasers() {
        return Util.getAllObjectsFromType(Laser.class, this);
    }

    private void stop() {
        gameLoopStopper.run();
        clear();
    }
}