package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.Navigator;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SpaceKeyScenSwitcher implements EventHandler<KeyEvent> {

    private Navigator navigator;
    private EnumScene gotoScene;
    private Scene from;

    private boolean pressed;

    public SpaceKeyScenSwitcher(Navigator navigator, EnumScene gotoScene, Scene from) {
        this.navigator = navigator;
        this.gotoScene = gotoScene;
        this.from = from;
        from.setOnKeyPressed(this);
        from.setOnKeyReleased(this);
    }


    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED) && event.getCode() == KeyCode.SPACE && !pressed) {
            pressed = true;
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED) && pressed) {
            pressed = false;
            navigator.goTo(gotoScene);
        }
    }


}
