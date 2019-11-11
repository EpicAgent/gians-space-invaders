package mvc.number_incrementer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class View {
    private final Controller controller;
    private final Model model;
    private Scene scene;
    private Label numberLabel;
    private Button incrementButton;
    private TextField incrementStepTextField;

    public View (Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        HBox hBox = new HBox(25);
        VBox vBox = new VBox(25);
        hBox.setPadding(new Insets(25));
        incrementStepTextField = new TextField(Integer.toString(model.getIncrementStep()));
        vBox.getChildren().addAll(incrementStepTextField, hBox);

        incrementButton = new Button("Increment");
        numberLabel = new Label(Integer.toString(model.getCurrentValue()));
        hBox.getChildren().addAll(incrementButton, numberLabel);
        Scene scene = new Scene(vBox);
        this.scene = scene;
        listenToModelChange();
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
                controller.updateIncrementStep(Integer.parseInt(newValue.trim()));
            }

        });
    }

    private void registerButtonActionHandler() {
        incrementButton.setOnAction(actionEvent -> controller.incrementCurrentValue());
    }

    private void listenToModelChange() {
        model.currentValueProperty().addListener((observableValue, oldNumber, newNumber) -> {
            numberLabel.setText(newNumber.toString());
            incrementStepTextField.setText(Integer.toString(model.getIncrementStep()));
        });

    }

    public Scene getScene() {
        return scene;
    }
}
