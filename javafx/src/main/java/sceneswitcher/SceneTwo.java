package sceneswitcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import sceneswitcher.enums.SceneType;

public class SceneTwo extends Scene {
    private static HBox rootNode = new HBox();

    public SceneTwo() {
        super(rootNode, 200, 120);
        Button button = new Button("Go back to scene one");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SceneSwitcher.switchToScene(SceneType.ONE);
            }
        });
        rootNode.setPadding(new Insets(25));
        rootNode.getChildren().add(button);
    }
}
