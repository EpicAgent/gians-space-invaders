package ch.bbcag.bubblepop;

import ch.bbcag.bubblepop.common.Navigator;
import ch.bbcag.bubblepop.gui.GameScene;
import ch.bbcag.bubblepop.gui.GameWonScene;
import ch.bbcag.bubblepop.gui.SceneType;
import ch.bbcag.bubblepop.gui.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class BubblePopApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("BubblePop");

        Navigator<SceneType> navigator = new Navigator<>(stage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAME_WON, new GameWonScene(navigator));

        navigator.goTo(SceneType.WELCOME);

        stage.show();
    }
}
