package scenenavigator.mvc;

import javafx.application.Application;
import javafx.stage.Stage;
import scenenavigator.mvc.common.Navigator;
import scenenavigator.mvc.controllers.SceneOneController;
import scenenavigator.mvc.common.enums.SceneType;
import scenenavigator.mvc.models.SceneOneModel;
import scenenavigator.mvc.views.SceneOne;
import scenenavigator.mvc.views.SceneTwo;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Navigator navigator = new Navigator(primaryStage);
        SceneOneModel sceneOneModel = new SceneOneModel();
        SceneOneController sceneOneController = new SceneOneController(sceneOneModel);
        navigator.registerScene(SceneType.ONE, new SceneOne(navigator, sceneOneModel, sceneOneController));
        navigator.registerScene(SceneType.TWO, new SceneTwo(navigator));
        navigator.navigateTo(SceneType.ONE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
