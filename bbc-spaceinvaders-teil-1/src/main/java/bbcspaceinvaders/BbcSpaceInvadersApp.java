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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Space Invaders");

        Navigator navigator = new Navigator(stage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));

        navigator.goTo(SceneType.WELCOME);
        stage.show();
    }
}