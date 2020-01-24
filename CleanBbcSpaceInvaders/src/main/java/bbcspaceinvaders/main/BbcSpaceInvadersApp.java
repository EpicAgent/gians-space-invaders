package bbcspaceinvaders.main;

import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.gui.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class BbcSpaceInvadersApp extends Application {

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