package bbcspaceinvaders.main;

import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.gui.*;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class BbcSpaceInvadersApp  extends Application {

    private Canvas canvas;
    private Space space;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {

        stage.setTitle("Bbc SpaceInvaders");

        Navigator navigator = new Navigator(stage);
        navigator.registerScene(EnumScene.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(EnumScene.GAME, new GameScene(navigator));
        navigator.registerScene(EnumScene.GAME_OVER, new GameOverScene(navigator));
        navigator.registerScene(EnumScene.GAME_WON, new GameWonScene(navigator));

        navigator.goTo(EnumScene.WELCOME);

        stage.show();

    }


}