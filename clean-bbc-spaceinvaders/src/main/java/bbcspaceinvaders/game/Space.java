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
        add(new Alienship(100, 20, this));
        add(new Alienship(200, 20, this));
        add(new Alienship(300, 20, this));
        add(new Alienship(400, 20, this));
        add(new Alienship(500, 20, this));
        add(new Alienship(600, 20, this));
        add(new Alienship(700, 20, this));

        add(new Alienship(100, 120, this));
        add(new Alienship(200, 120, this));
        add(new Alienship(300, 120, this));
        add(new Alienship(400, 120, this));
        add(new Alienship(500, 120, this));
        add(new Alienship(600, 120, this));
        add(new Alienship(700, 120, this));
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