package bbcspaceinvaders;

import javafx.scene.input.KeyCode;

public class WelcomeScene extends BaseScene {

    public WelcomeScene(Navigator navigator) {
        super(navigator, Images.WELCOME);

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                NAVI.goTo(SceneType.GAME);
            }
        });
    }
}
