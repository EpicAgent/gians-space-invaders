package sceneswitcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SceneOne extends Scene {
    private Scene scene;
    private int number = 0;
    private Label numberLabel;
    private static VBox rootNode = new VBox(10);


    public SceneOne() {
        super(rootNode);
        rootNode.setPadding(new Insets(25));
        HBox hBox = new HBox(10);
        Button incrementButton = new Button("Increment");
        incrementButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                number++;
                numberLabel.setText(Integer.toString(number));
            }
        });
        numberLabel = new Label("0");
        hBox.getChildren().addAll(incrementButton, numberLabel);

        Button nextButton = new Button("Go to scene two");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SceneSwitcher.switchToScene("two");

            }
        });
        rootNode.getChildren().addAll(hBox, nextButton);

        scene = new Scene(rootNode, 200, 120);
    }
}
