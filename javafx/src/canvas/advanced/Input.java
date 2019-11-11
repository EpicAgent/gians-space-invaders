package canvas.advanced;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input implements EventHandler<KeyEvent> {

    private static Input instance = null;

    public static Input getInstance() {
        if (instance == null) {
            instance = new Input();
        }

        return instance;
    }

    public static boolean isLeft() {
        return getInstance().isInputLeft();
    }

    public static boolean isRight() {
        return getInstance().inputRight;
    }



    private boolean inputLeft = false;
    private boolean inputRight = false;


    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) {
            if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
                inputLeft = true;
            }
            if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
                inputRight = true;
            }
        }

        if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) {
            if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == KeyCode.A) {
                inputLeft = false;
            }
            if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == KeyCode.D) {
                inputRight = false;
            }
        }
    }

    public boolean isInputLeft() {
        return inputLeft;
    }

    public boolean isInputRight() {
        return inputRight;
    }


}
