package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.game.Images;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class GameWonScene extends BaseScene {

    private static final Group root = new Group();

    public GameWonScene(Navigator navigator) {
        super(navigator, root, Images.GAME_WON_BACKGROUND_IMAGE);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }
}
