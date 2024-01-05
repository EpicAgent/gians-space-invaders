package ch.bbcag.bubblepop.common;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator<sceneKey> {

    private final Stage stage;
    private final Map<sceneKey, Scene> viewMap = new HashMap<>();

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(sceneKey enumScene, Scene scene) {
        viewMap.put(enumScene, scene);
    }

    public void goTo(sceneKey sceneKey) {
        Scene targetScene = viewMap.get(sceneKey);

        if (targetScene instanceof Initializable) {
            ((Initializable) targetScene).onInitialize();
        }

        stage.setScene(targetScene);
    }

}
