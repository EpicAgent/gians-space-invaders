package numberconverter.withfxml.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import numberconverter.withfxml.enums.Mode;
import numberconverter.withfxml.model.Model;


public class NumberConverterController {

    @FXML
    private Label decLabel;

    @FXML
    private Label binLabel;

    @FXML
    private Label hexLabel;

    @FXML
    private Label octLabel;

    @FXML
    private TextField numberTextField;

    @FXML
    private ToggleGroup numberToggleGroup;

    private Model model;

    @FXML
    private void initialize() {

        model = new Model();
        model.valueProperty().addListener((observableValue, oldNumer, newNumber) -> updateLabels(newNumber));

        numberTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("")) {
                model.setValue(0);
                return;
            }
            try {
                switch (model.getCurrentMode()) {
                    case DEC:
                        model.setValue(Integer.parseInt(numberTextField.getText()));
                        break;
                    case BIN:
                        model.setValue(Integer.parseInt(numberTextField.getText(), 2));
                        break;
                    case HEX:
                        model.setValue(Integer.parseInt(numberTextField.getText(), 16));
                        break;
                    case OCT:
                        model.setValue(Integer.parseInt(numberTextField.getText(), 8));
                }
            } catch (NumberFormatException e) {
                model.setValue(0);
                numberTextField.setText(oldValue);
            }

        });

        updateLabels(0);

        numberToggleGroup.selectedToggleProperty().addListener((observableValue, oldToggle, newToggle) -> {
            switch (newToggle.getUserData().toString()) {
                case "DEC":
                    model.setCurrentMode(Mode.DEC);
                    numberTextField.setText(Integer.toString(model.getValue()));
                    break;
                case "BIN":
                    model.setCurrentMode(Mode.BIN);
                    numberTextField.setText(Integer.toBinaryString(model.getValue()));
                    break;
                case "HEX":
                    model.setCurrentMode(Mode.HEX);
                    numberTextField.setText(Integer.toHexString(model.getValue()));
                    break;
                case "OCT":
                    model.setCurrentMode(Mode.OCT);
                    numberTextField.setText(Integer.toOctalString(model.getValue()));
                    break;
            }
        });


    }

    private void updateLabels(Number number) {
        decLabel.setText(Integer.toString(number.intValue()));
        binLabel.setText(Integer.toBinaryString(number.intValue()));
        hexLabel.setText(Integer.toHexString(number.intValue()));
        octLabel.setText(Integer.toOctalString(number.intValue()));
    }



}
