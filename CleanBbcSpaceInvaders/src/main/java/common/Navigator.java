package bbcspaceinvaders.common;

import bbcspaceinvaders.gui.EnumScene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private Map<EnumScene, GUIScene> viewMap = new HashMap<EnumScene, GUIScene>();
    private Stage stage;
    private GUIScene activeScene;

    public Navigator(Stage stage) {
        this.stage = stage;
    }

    public void registerScene(EnumScene enumScene, GUIScene scene) {
        viewMap.put(enumScene, scene);
    }

    public void goTo(EnumScene scene) {
        if (activeScene != null) {
            activeScene.onClose();
        }
        activeScene = viewMap.get(scene);
        stage.setScene(activeScene);
        activeScene.onOpen();
    }

}
