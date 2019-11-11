package eventhandling.implementing_event_handler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

public class ButtonClickController implements EventHandler<ActionEvent> {
    private Text text;

    public ButtonClickController(Text text) {
        this.text = text;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        text.setText("Button was clicked!");
    }
}
