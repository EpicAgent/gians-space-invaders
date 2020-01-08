package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.GUIScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Const;
import javafx.scene.Group;

public class GameOverScene extends GUIScene {

    private static Group group = new Group();


    public GameOverScene(Navigator navigator) {
        super(group, navigator);
        new SpaceKeyScenSwitcher(navigator, EnumScene.WELCOME, this);
    }

    @Override
    public void onOpen() {
        getGraphicsContext().drawImage(Const.GAME_OVER_BACKGROUND_IMAGE, 0, 0);
    }
}
