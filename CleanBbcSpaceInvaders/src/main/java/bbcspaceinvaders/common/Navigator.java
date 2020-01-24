package bbcspaceinvaders.common;

import bbcspaceinvaders.gui.EnumScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Map<EnumScene, Scene> viewMap = new HashMap<>();
    private Stage stage;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(EnumScene enumScene, BaseScene scene) {
        viewMap.put(enumScene, scene);
    }

    public void goTo(EnumScene scene) {
        Scene activeScene = viewMap.get(scene);

        if (activeScene instanceof Initializable){
            ((Initializable)activeScene).onInitialize();
        }

        stage.setScene(activeScene);
    }
}
