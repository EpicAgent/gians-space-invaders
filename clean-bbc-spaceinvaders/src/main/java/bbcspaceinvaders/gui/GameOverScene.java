package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Initializable;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.game.Images;
import bbcspaceinvaders.game.Sound;
import bbcspaceinvaders.game.SoundEffectType;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class GameOverScene extends BaseScene implements Initializable {

    private static final Group root = new Group();

    public GameOverScene(Navigator navigator) {
        super(navigator, root, Images.GAME_OVER_BACKGROUND);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.goTo(SceneType.WELCOME);
            }
        });
    }

    @Override
    public void onInitialize() {
        Sound.play(SoundEffectType.SPACESHIP_EXPLODE);
    }
}
