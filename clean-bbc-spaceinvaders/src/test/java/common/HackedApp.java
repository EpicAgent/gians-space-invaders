package common;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spaceinvaders.App;
import spaceinvaders.game.GameLoop;
import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.sound.Sound;
import spaceinvaders.scenes.GameOverScene;
import spaceinvaders.scenes.GameScene;
import spaceinvaders.scenes.GameWonScene;
import spaceinvaders.scenes.WelcomeScene;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.Weapon;
import spaceinvaders.game.Space;
import spaceinvaders.game.GameObjects;
import spaceinvaders.game.gameobjects.Spaceship;

import java.util.Arrays;

public class HackedApp extends App {

    private Stage stage;
    protected Hacker hacker;

    public HackedApp(Stage stage, Hacker hacker) {
        this.stage = stage;
        this.hacker = hacker;
        this.context = new AnnotationConfigApplicationContext(); // Hier wird der hackable ApplicationContext injected.
    }

    public void setupContext() {
        /*Arrays.asList(
                Navigator.class, WelcomeScene.class, GameScene.class, GameWonScene.class,
                GameOverScene.class, Space.class, Spaceship.class, KeyEventHandler.class,
                CollisionHandler.class, GameObjects.class, Weapon.class, GameLoop.class,
                Sound.class)
                .forEach(component -> hacker.getComponentOrFake(component));
        hacker.setupGameObjectFactory();
        context.refresh();*/
    }

    public void start() {

        Platform.runLater(() -> { // Die App muss auf dem Java FX Thread laufen.
            //TODO
            //super.setApplicationContextForTesting(context);
            super.start(stage);
        });

        Util.threadSleep(100); // TODO: Hässlich, aber es muss kurz auf den Java Fx Thread gewartet werden.
    }

    public void setupAndStart() {
        setupContext();
        start();
    }

    public void close() {
        // TODO
        //super.stop();
        //context.close();
    }
}