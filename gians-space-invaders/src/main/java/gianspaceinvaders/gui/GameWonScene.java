package gianspaceinvaders.gui;

import gianspaceinvaders.common.BaseScene;
import gianspaceinvaders.common.Navigator;
import gianspaceinvaders.game.Images;
import javafx.scene.input.KeyCode;

public class GameWonScene extends BaseScene {

    public GameWonScene(Navigator<SceneType> navigator) {
        super(navigator, Images.GAME_WON_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }

}
