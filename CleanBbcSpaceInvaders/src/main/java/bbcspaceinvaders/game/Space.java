package bbcspaceinvaders.game;

import bbcspaceinvaders.common.FancyAnimationTimer;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.common.Util;
import bbcspaceinvaders.game.gameobjects.*;
import bbcspaceinvaders.gui.EnumScene;
import bbcspaceinvaders.main.Images;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Space extends CopyOnWriteArrayList<GameObject> {

    private KeyEventHandler keyEventHandler;
    private GraphicsContext graphicsContext;
    private CollisionHandler collisionHandler;
    private Navigator navigator;
    private AnimationTimer gameLoop;

    public Space(KeyEventHandler keyEventHandler, GraphicsContext graphicsContext, Navigator navigator) {
        this.keyEventHandler = keyEventHandler;
        this.graphicsContext = graphicsContext;

        this.collisionHandler = new CollisionHandler(this);
        this.navigator = navigator;
    }

    public void start() {
        gameLoop = new FancyAnimationTimer() {
            @Override
            public void handle(double deltaInSec) {
                update(deltaInSec);
                paint();
            }
        };
        gameLoop.start();
    }

    private void stop() {
        gameLoop.stop();
        clear();
    }

    public void load() {
        add(new Spaceship(keyEventHandler, this));
        add(new Alienship(300, 20, this));
        add(new Alienship(500, 20, this));
    }

    private void paint() {
        graphicsContext.clearRect(0, 0, 800, 600);
        graphicsContext.drawImage(Images.GAME_BACKGROUND_IMAGE, 0, 0);
        for (GameObject object : this) {
            object.draw(graphicsContext);
        }
    }

    private void update(double deltaInSec) {
        for (GameObject object : this) {
            object.update(deltaInSec);
        }
        collisionHandler.handle();

        if (Util.getAllObjectsFromType(Spaceship.class, this).isEmpty()) {
            navigator.goTo(EnumScene.GAME_OVER);
            stop();
        } else if (getAlienShips().isEmpty()) {
            navigator.goTo(EnumScene.GAME_WON);
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
}