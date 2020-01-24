package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.main.Images;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class GameOverScene extends BaseScene {

    private static final Group root = new Group();

    public GameOverScene(Navigator navigator) {
        super(navigator, root, Images.GAME_OVER_BACKGROUND_IMAGE);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(EnumScene.WELCOME);
            }
        });
    }
}
