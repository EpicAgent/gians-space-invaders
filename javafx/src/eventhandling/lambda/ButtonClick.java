package eventhandling.lambda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonClick extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(20);
        Button button = new Button("Click me!");
        Text text = new Text();
        button.setOnAction(actionEvent -> {
            text.setText("Button was clicked!");
        });
        vBox.getChildren().addAll(button, text);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
