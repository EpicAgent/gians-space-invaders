package scenenavigator.simple.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scenenavigator.simple.common.Navigator;
import scenenavigator.simple.common.enums.SceneType;

public class SceneOne extends Scene {
    private int number = 0;
    private Label numberLabel;
    private static VBox rootNode = new VBox(10);


    public SceneOne(Navigator navigator) {
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
                navigator.navigateTo(SceneType.TWO);

            }
        });
        rootNode.getChildren().addAll(hBox, nextButton);
    }
}
