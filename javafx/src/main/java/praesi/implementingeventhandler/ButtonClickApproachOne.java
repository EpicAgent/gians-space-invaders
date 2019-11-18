package praesi.implementingeventhandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonClickApproachOne extends Application implements EventHandler<ActionEvent> {

    private Text text;

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(25));
        Button button = new Button("Click me!");
        button.setOnAction(this);
        text = new Text();
        vBox.getChildren().addAll(button, text);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        text.setText("Button was clicked!");
    }
}
