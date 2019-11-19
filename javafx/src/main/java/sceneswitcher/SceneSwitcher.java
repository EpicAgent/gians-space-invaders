package sceneswitcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sceneswitcher.enums.SceneType;

import java.util.HashMap;
import java.util.Map;

public class SceneSwitcher extends Application {

    private static Map<SceneType, Scene> sceneMap;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        sceneMap = new HashMap<>();
        registerScenes();
        primaryStage.setScene(sceneMap.get(SceneType.ONE));
        primaryStage.show();
    }

    private void registerScenes() {
        sceneMap.put(SceneType.ONE, new SceneOne());
        sceneMap.put(SceneType.TWO, new SceneTwo());
    }

    public static void switchToScene(String sceneKey) {
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage.setScene(sceneMap.get(sceneKey));

        // By default stage doesn't retain its width after calling stage.setScene(...) so we have to set width and height manually
        stage.setWidth(width);
        stage.setHeight(height);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
