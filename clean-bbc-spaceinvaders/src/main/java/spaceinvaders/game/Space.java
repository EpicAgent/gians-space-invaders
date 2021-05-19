package spaceinvaders.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Navigator;
import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.common.Util;
import spaceinvaders.game.gameobjects.Spaceship;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.images.ImageType;
import spaceinvaders.images.Images;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;

@Component
public class Space {

    private final Navigator navigator;
    private CollisionHandler collisionHandler;
    private final GameObjects gameObjects;
    private GameLoop gameLoop;
    private Sound sound;

    @Autowired
    public Space(@Lazy Navigator navigator, GameObjects gameObjects, CollisionHandler collisionHandler, GameLoop gameLoop, Sound sound) {
        this.navigator = navigator;
        this.collisionHandler = collisionHandler;
        this.gameObjects = gameObjects;
        this.gameLoop = gameLoop;
        this.sound = sound;
    }

    public void initialize() {
        gameObjects.initialize();
        sound.play(MusicType.BACKGROUND);
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(Images.load(ImageType.GAME_BACKGROUND), 0, 0);
        gameObjects.forEach(gameObject -> gameObject.draw(gc));
    }

    public void update(double deltaInSec) {

        if (mankindExterminated()) {
            stopGame(SceneType.GAME_OVER);
            return;
        }

        if (alienExterminated()) {
            stopGame(SceneType.GAME_WON);
            return;
        }

        gameObjects.forEach(gameObject -> gameObject.update(deltaInSec));;
        collisionHandler.handle();
    }

    public boolean mankindExterminated() {
        return Util.getAllObjectsFromType(Spaceship.class, gameObjects).isEmpty();
    }

    public boolean alienExterminated() {
        return gameObjects.getAlienShips().isEmpty();
    }

    private void stopGame(SceneType sceneToNavigate) {
        gameLoop.stop();
        navigator.navigateTo(sceneToNavigate);
        gameObjects.clear();
    }
}