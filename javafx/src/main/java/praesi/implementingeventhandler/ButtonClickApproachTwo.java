package praesi.implementingeventhandler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonClickApproachTwo extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(25));
        Button button = new Button("Click mee!");
        Text text = new Text();
        ButtonClickController controller = new ButtonClickController(text);
        button.setOnAction(controller);
        vBox.getChildren().addAll(button, text);
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
