package eventhandling;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseClickHandler implements EventHandler<MouseEvent> {

    private ClickCountLabel clickCountLabel;

    public MouseClickHandler(ClickCountLabel clickCountLabel) {
        this.clickCountLabel = clickCountLabel;
    }

    @Override
    public void handle(MouseEvent event) {
        clickCountLabel.incrementNumberOfClicks();
    }
}
