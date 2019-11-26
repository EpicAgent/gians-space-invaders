package scenenavigator.mvc.views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import scenenavigator.mvc.common.Navigator;
import scenenavigator.mvc.controllers.SceneOneController;
import scenenavigator.mvc.common.enums.SceneType;
import scenenavigator.mvc.models.SceneOneModel;

public class SceneOne extends Scene {
    private Label numberLabel;
    private static VBox rootNode = new VBox(10);
    private SceneOneModel model;


    public SceneOne(Navigator navigator, SceneOneModel model, SceneOneController controller) {
        super(rootNode);
        this.model = model;
        rootNode.setPadding(new Insets(25));
        HBox hBox = new HBox(10);
        Button incrementButton = new Button("Increment");
        incrementButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.incrementNumber();
            }
        });
        numberLabel = new Label(Integer.toString(model.getNumber()));
        hBox.getChildren().addAll(incrementButton, numberLabel);

        Button nextButton = new Button("Go to scene two");
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                navigator.navigateTo(SceneType.TWO);
            }
        });
        rootNode.getChildren().addAll(hBox, nextButton);

        registerOnNumberChange();
    }

    private void registerOnNumberChange() {
        model.numberProperty().addListener((observable, oldValue, newValue) -> numberLabel.setText(newValue.toString()));
    }
}
