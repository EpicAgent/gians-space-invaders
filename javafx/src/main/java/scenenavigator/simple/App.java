package scenenavigator.simple;

import javafx.application.Application;
import javafx.stage.Stage;
import scenenavigator.simple.enums.SceneType;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.ONE, new SceneOne(navigator));
        navigator.registerScene(SceneType.TWO, new SceneTwo(navigator));
        navigator.navigateTo(SceneType.ONE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
