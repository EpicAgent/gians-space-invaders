package sceneswitcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class SceneSwitcher extends Application {

    private static Map<String, Scene> sceneProviders;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        sceneProviders = new HashMap<>();
        SceneOne sceneOne = new SceneOne();
        SceneTwo sceneTwo = new SceneTwo();
        sceneProviders.put("one", sceneOne);
        sceneProviders.put("two", sceneTwo);
        primaryStage.setScene(sceneOne);
        primaryStage.show();
    }


    public static void switchToScene(String sceneKey) {
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage.setScene(sceneProviders.get(sceneKey));

        // By default stage doesn't retain its width after calling stage.setScene(...) so we have to set width and height manually
        stage.setWidth(width);
        stage.setHeight(height);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
