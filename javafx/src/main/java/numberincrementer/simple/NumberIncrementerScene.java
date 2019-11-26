package numberincrementer.simple;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NumberIncrementerScene {

    private Scene scene;
    private Label numberLabel;
    private Button incrementButton;
    private TextField incrementStepTextField;

    private int incrementStep = 1;
    private int currentNumber = 1;


    public NumberIncrementerScene() {
        HBox hBox = new HBox(25);
        VBox vBox = new VBox(25);
        hBox.setPadding(new Insets(25));
        incrementStepTextField = new TextField(Integer.toString(incrementStep));
        vBox.getChildren().addAll(incrementStepTextField, hBox);

        incrementButton = new Button("Increment");
        numberLabel = new Label(Integer.toString(currentNumber));
        hBox.getChildren().addAll(incrementButton, numberLabel);
        Scene scene = new Scene(vBox);
        this.scene = scene;
        registerButtonActionHandler();
        registerIncrementStepTextFieldChangedHandler();
    }

    private void registerIncrementStepTextFieldChangedHandler() {
        incrementStepTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.trim().equals("") || newValue.trim().equals("-")) {
                return;
            } else if(!newValue.matches("-?[0-9]*")) {
                incrementStepTextField.setText(oldValue);
            } else {
                incrementStep = Integer.parseInt(newValue.trim());
            }
        });
    }

    private void registerButtonActionHandler() {
        incrementButton.setOnAction(actionEvent -> {
            currentNumber += incrementStep;
            numberLabel.setText(Integer.toString(currentNumber));
        });
    }

    public Scene getScene() {
        return scene;
    }
}
