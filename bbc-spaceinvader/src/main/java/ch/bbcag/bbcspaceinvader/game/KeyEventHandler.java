package ch.bbcag.bbcspaceinvader.game;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyEventHandler implements EventHandler<KeyEvent> {

	private boolean isLeftKeyPressed = false;
	private boolean isRightKeyPressed = false;
	private boolean isSpaceKeyPressed = false;
		
    public boolean isLeftKeyPressed() {
        return isLeftKeyPressed;
    }

    public boolean isRightKeyPressed() {
        return isRightKeyPressed;
    }
    
    public boolean isSpaceKeyPressed() {
        return isSpaceKeyPressed;
    }
	
	@Override
	public void handle(KeyEvent event) {

		if (event.getEventType() == KeyEvent.KEY_PRESSED) {
			setKeyStates(event, true);
		}

		if (event.getEventType() == KeyEvent.KEY_RELEASED) {
			setKeyStates(event, false);
		}
	}

	private void setKeyStates(KeyEvent keyEvent, boolean newState) {
		if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
			isLeftKeyPressed = newState;
		}
		if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
			isRightKeyPressed = newState;
		}
		if (keyEvent.getCode() == KeyCode.SPACE) {
			isSpaceKeyPressed = newState;
		}
	}	
}