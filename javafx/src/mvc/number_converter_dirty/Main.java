package mvc.number_converter_dirty;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import mvc.number_converter_dirty.enums.Mode;

public class Main extends Application {

    private Scene scene;
    private final TextField inputTextField = new TextField("0");
    private final ToggleGroup numberFormatToggleGroup = new ToggleGroup();
    private final RadioButton hexadecimalRadioButton = new RadioButton("HEX:");
    private final RadioButton decimalRadioButton = new RadioButton("DEC:");
    private final RadioButton octalRadioButton = new RadioButton("OCT:");
    private final RadioButton binaryRadioButton = new RadioButton("BIN:");

    private final Label hexadecimalResultLabel = new Label("0");
    private final Label decimalResultLabel = new Label("0");
    private final Label octalResultLabel = new Label("0");
    private final Label binaryResultLabel = new Label("0");

    private IntegerProperty currentValue = new SimpleIntegerProperty(0);
    private Mode currentMode = Mode.DEC;

    @Override
    public void start(Stage primaryStage) {
        GridPane rootPane = new GridPane();
        rootPane.setVgap(10);
        rootPane.setHgap(10);
        rootPane.setPadding(new Insets(20));

        inputTextField.setAlignment(Pos.BASELINE_RIGHT);
        hexadecimalResultLabel.setAlignment(Pos.BASELINE_RIGHT);
        decimalResultLabel.setAlignment(Pos.BASELINE_RIGHT);
        octalResultLabel.setAlignment(Pos.BASELINE_RIGHT);
        binaryResultLabel.setAlignment(Pos.BASELINE_RIGHT);

        hexadecimalResultLabel.setMaxWidth(Double.MAX_VALUE);
        decimalResultLabel.setMaxWidth(Double.MAX_VALUE);
        octalResultLabel.setMaxWidth(Double.MAX_VALUE);
        binaryResultLabel.setMaxWidth(Double.MAX_VALUE);

        hexadecimalRadioButton.setToggleGroup(numberFormatToggleGroup);
        decimalRadioButton.setToggleGroup(numberFormatToggleGroup);
        octalRadioButton.setToggleGroup(numberFormatToggleGroup);
        binaryRadioButton.setToggleGroup(numberFormatToggleGroup);
        hexadecimalRadioButton.setUserData(Mode.HEX);
        decimalRadioButton.setUserData(Mode.DEC);
        octalRadioButton.setUserData(Mode.OCT);
        binaryRadioButton.setUserData(Mode.BIN);

        decimalRadioButton.setSelected(true);
        registerListeners();

        rootPane.addRow(0, inputTextField);
        rootPane.addRow(1, decimalRadioButton, decimalResultLabel);
        rootPane.addRow(2, binaryRadioButton, binaryResultLabel);
        rootPane.addRow(3, hexadecimalRadioButton, hexadecimalResultLabel);
        rootPane.addRow(4, octalRadioButton, octalResultLabel);

        GridPane.setColumnSpan(inputTextField, 2);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        rootPane.getColumnConstraints().add(columnConstraints);

        scene = new Scene(rootPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void registerListeners() {

        currentValue.addListener((observableValue, oldNumer, newNumber) -> updateLabels(newNumber.intValue()));

        inputTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("")) {
                currentValue.setValue(0);
                return;
            }
            try {
                switch (currentMode) {
                    case DEC:
                        currentValue.setValue(Integer.parseInt(newValue));
                        break;
                    case BIN:
                        currentValue.setValue(Integer.parseInt(newValue, 2));
                        break;
                    case HEX:
                        currentValue.setValue(Integer.parseInt(newValue, 16));
                        break;
                    case OCT:
                        currentValue.setValue(Integer.parseInt(newValue, 8));
                }
            } catch (NumberFormatException e) {
                inputTextField.setText(oldValue);
            }

        });

        numberFormatToggleGroup.selectedToggleProperty().addListener((observableValue, oldToggle, newToggle) -> {
            switch ((Mode)newToggle.getUserData()) {
                case DEC:
                    currentMode = Mode.DEC;
                    inputTextField.setText(Integer.toString(currentValue.intValue()));
                    break;
                case BIN:
                    currentMode = Mode.BIN;
                    inputTextField.setText(Integer.toBinaryString(currentValue.intValue()));
                    break;
                case HEX:
                    currentMode = Mode.HEX;
                    inputTextField.setText(Integer.toHexString(currentValue.intValue()));
                    break;
                case OCT:
                    currentMode = Mode.OCT;
                    inputTextField.setText(Integer.toOctalString(currentValue.intValue()));
                    break;
            }
        });
    }



    public void updateLabels(int number) {
        decimalResultLabel.setText(Integer.toString(number));
        binaryResultLabel.setText(Integer.toBinaryString(number));
        hexadecimalResultLabel.setText(Integer.toHexString(number));
        octalResultLabel.setText(Integer.toOctalString(number));
    }


}
