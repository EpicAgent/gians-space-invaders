package numberconverter.withoutfxml.view;

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
import numberconverter.withoutfxml.controller.Controller;
import numberconverter.withoutfxml.enums.Mode;
import numberconverter.withoutfxml.model.Model;


public class View {

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

    private final Controller controller;
    private final Model model;

    public View(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
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

        registerListeners();

    }

    private void registerListeners() {
        registerTextInputListener();
        registerRadioButtonToggleListener();
        registerMainDisplayValueChangeListener();
        registerLabelDisplayValueChangeListeners();
    }

    private void registerLabelDisplayValueChangeListeners() {
        model.decDisplayValueProperty().addListener((observableValue, oldValue, newValue) -> decimalResultLabel.setText(newValue));
        model.binDisplayValueProperty().addListener((observableValue, oldValue, newValue) -> binaryResultLabel.setText(newValue));
        model.hexDisplayValueProperty().addListener((observableValue, oldValue, newValue) -> hexadecimalResultLabel.setText(newValue));
        model.octDisplayValueProperty().addListener((observableValue, oldValue, newValue) -> octalResultLabel.setText(newValue));
    }

    private void registerMainDisplayValueChangeListener() {
        model.mainDisplayValueProperty().addListener((observableValue, oldValue, newValue) -> {
            inputTextField.setText(newValue);
        });
    }

    private void registerRadioButtonToggleListener() {
        numberFormatToggleGroup.selectedToggleProperty().addListener((observableValue, oldToggle, newToggle) -> {
            controller.handleModeChange((Mode)newToggle.getUserData());
        });
    }

    private void registerTextInputListener() {
        inputTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (controller.handleTextInput(newValue)) {
                controller.updateDisplayValues();
            } else {
                inputTextField.setText(oldValue);
            }

        });
    }

    public Scene getScene() {
        return scene;
    }


}
