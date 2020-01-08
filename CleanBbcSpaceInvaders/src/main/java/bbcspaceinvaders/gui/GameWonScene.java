package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.GUIScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Const;
import javafx.scene.Group;

public class GameWonScene extends GUIScene {

    private static Group group = new Group();

    public GameWonScene(Navigator navigator){
        super(group, navigator);
        new SpaceKeyScenSwitcher(navigator, EnumScene.WELCOME, this);
    }

    @Override
    public void onOpen() {
        getGraphicsContext().drawImage(Const.GAME_WON_BACKGROUND_IMAGE, 0, 0);
    }
}
