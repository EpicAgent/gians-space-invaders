package ch.bbcag.bubblepop.gui;

import ch.bbcag.bubblepop.common.BaseScene;
import ch.bbcag.bubblepop.common.Navigator;
import ch.bbcag.bubblepop.game.Images;
import javafx.scene.input.KeyCode;

public class WelcomeScene extends BaseScene {
    public WelcomeScene(Navigator<SceneType> navigator) {
        super(navigator, Images.WELCOME_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.goTo(SceneType.GAME);
            }
        });
    }
}
