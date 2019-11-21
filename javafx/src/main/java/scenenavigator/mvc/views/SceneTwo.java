package scenenavigator.mvc.views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import scenenavigator.mvc.common.Navigator;
import scenenavigator.mvc.common.enums.SceneType;

public class SceneTwo extends Scene {
    private static HBox rootNode = new HBox();

    public SceneTwo(Navigator navigator) {
        super(rootNode);
        Button button = new Button("Go back to scene one");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                navigator.navigateTo(SceneType.ONE);
            }
        });
        rootNode.setPadding(new Insets(25));
        rootNode.getChildren().add(button);
    }
}
