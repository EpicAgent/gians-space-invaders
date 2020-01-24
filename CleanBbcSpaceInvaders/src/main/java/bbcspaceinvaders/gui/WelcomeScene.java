package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Images;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class WelcomeScene extends BaseScene {

    private static final Group root = new Group();

    public WelcomeScene(Navigator navigator) {
        super(navigator, root, Images.WELCOME_BACKGROUND_IMAGE);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(EnumScene.GAME);
            }
        });
    }
}
