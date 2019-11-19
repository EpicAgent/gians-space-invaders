package scenenavigator;

import javafx.scene.Scene;
import javafx.stage.Stage;
import scenenavigator.enums.SceneType;
import scenenavigator.interfaces.INavigatable;

import java.util.HashMap;
import java.util.Map;

public class Navigator {
    private Stage stage;
    private Map<SceneType, Scene> sceneMap = new HashMap<>();

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(SceneType sceneType, Scene scene) {
        sceneMap.put(sceneType, scene);
    }

    public void navigateTo(SceneType sceneType) {
        stage.setScene(sceneMap.get(sceneType));
        stage.show();
    }

    public <T> void navigateTo(SceneType key, T arg) {
        Scene scene = sceneMap.get(key);
        ((INavigatable<T>)scene).navigatedTo(arg);

        stage.setScene(scene);
        stage.show();
    }
}
