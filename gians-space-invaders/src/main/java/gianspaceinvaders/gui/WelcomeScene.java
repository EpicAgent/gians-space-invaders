package gianspaceinvaders.gui;

import gianspaceinvaders.common.BaseScene;
import gianspaceinvaders.common.Initializable;
import gianspaceinvaders.common.Navigator;
import gianspaceinvaders.game.Images;
import gianspaceinvaders.game.MusicType;
import gianspaceinvaders.game.Sound;
import javafx.scene.input.KeyCode;

public class WelcomeScene extends BaseScene implements Initializable {

    public WelcomeScene(Navigator<SceneType> navigator) {
        super(navigator, Images.WELCOME_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.goTo(SceneType.GAME);
            }
        });
    }

    @Override
    public void onInitialize() {
        Sound.play(MusicType.INTRO);
    }

}
