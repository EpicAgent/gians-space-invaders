package gianspaceinvaders.main;

import gianspaceinvaders.common.Navigator;
import gianspaceinvaders.gui.GameOverScene;
import gianspaceinvaders.gui.GameScene;
import gianspaceinvaders.gui.GameWonScene;
import gianspaceinvaders.gui.SceneType;
import gianspaceinvaders.gui.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class GianSpaceInvadersApp extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Gian's Space Invaders");

        Navigator<SceneType> navigator = new Navigator<>(stage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAME_OVER, new GameOverScene(navigator));
        navigator.registerScene(SceneType.GAME_WON, new GameWonScene(navigator));

        navigator.goTo(SceneType.WELCOME);

        stage.show();
    }

}