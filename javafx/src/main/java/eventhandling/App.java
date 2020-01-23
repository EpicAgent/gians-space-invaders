package eventhandling;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends javafx.application.Application implements EventHandler<MouseEvent> {

    private ClickCountLabel clickCountLabel = new ClickCountLabel();

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox(10);

        Button buttonWithOtherClass = new Button("click me with other class");
        Button buttonWithThis = new Button("click me with this");
        Button buttonWithAnonymInnerClass = new Button("click me with anonymous inner class");

        Button buttonWithLambda = new Button("click me with lambda");

        buttonWithOtherClass.setOnMouseClicked(new MouseClickHandler(clickCountLabel));
        buttonWithThis.setOnMouseClicked(this);
        buttonWithAnonymInnerClass.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                clickCountLabel.incrementNumberOfClicks();
            }
        });
        buttonWithLambda.setOnMouseClicked(e -> clickCountLabel.incrementNumberOfClicks());

        vbox.getChildren().add(buttonWithOtherClass);
        vbox.getChildren().add(buttonWithThis);
        vbox.getChildren().add(buttonWithAnonymInnerClass);
        vbox.getChildren().add(buttonWithLambda);
        vbox.getChildren().add(clickCountLabel);

        stage.setScene(new Scene(vbox));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

    @Override
    public void handle(MouseEvent event) {
        clickCountLabel.incrementNumberOfClicks();
    }
}