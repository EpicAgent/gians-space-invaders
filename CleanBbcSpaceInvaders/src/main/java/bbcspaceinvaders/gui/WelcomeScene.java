package bbcspaceinvaders.gui;


import bbcspaceinvaders.common.GUIScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Const;
import javafx.scene.Group;

public class WelcomeScene extends GUIScene {

    private static Group group = new Group();

    public WelcomeScene(Navigator navigator){
        super(group, navigator);
        new SpaceKeyScenSwitcher(navigator, EnumScene.GAME, this);
    }

    @Override
    public void onOpen() {
        getGraphicsContext().drawImage(Const.WELCOME_BACKGROUND_IMAGE, 0, 0);
    }
}
