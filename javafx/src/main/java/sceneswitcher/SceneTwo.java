package sceneswitcher;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class SceneTwo implements SceneProvider {
    private Scene scene;

    public SceneTwo() {
        Button button = new Button("Go back to scene one");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SceneSwitcher.switchToScene("one");
            }
        });
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(25));
        hBox.getChildren().add(button);
        scene = new Scene(hBox, 200, 120);
    }


    public Scene getScene() {
        return scene;
    }
}
