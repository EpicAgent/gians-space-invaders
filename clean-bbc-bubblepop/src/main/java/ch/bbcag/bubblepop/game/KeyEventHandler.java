package ch.bbcag.bubblepop.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {
    private boolean isLeftKeyPressed = false;
    private boolean isRightKeyPressed = false;

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            if (event.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = true;
            }
            if (event.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = true;
            }
        }
        if (event.getEventType() == KeyEvent.KEY_RELEASED) {
            if (event.getCode() == KeyCode.LEFT) {
                isLeftKeyPressed = false;
            }
            if (event.getCode() == KeyCode.RIGHT) {
                isRightKeyPressed = false;
            }
        }
    }

    public boolean isLeftKeyPressed() {
        return isLeftKeyPressed;
    }

    public boolean isRightKeyPressed() {
        return isRightKeyPressed;
    }

}
