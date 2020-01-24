package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Images;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class GameWonScene extends BaseScene {

    private static final Group root = new Group();

    public GameWonScene(Navigator navigator) {
        super(navigator, root, Images.GAME_WON_BACKGROUND_IMAGE);
        //new SpaceKeyScenSwitcher(navigator, EnumScene.WELCOME, this);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(EnumScene.WELCOME);
            }
        });
    }
}
