package bbcspaceinvaders;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private final Stage STAGE;
    private final Map<SceneType, Scene> SCENES = new HashMap<>();

    public Navigator(Stage stage) {
        this.STAGE = stage;
    }

    public void registerScene(SceneType sceneType, Scene scene) {
        SCENES.put(sceneType, scene);
    }

    public void goTo(SceneType sceneType) {
        Scene scene = SCENES.get(sceneType);
        STAGE.setScene(scene);
    }
}
