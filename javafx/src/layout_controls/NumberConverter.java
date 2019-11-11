package layout_controls;

import javafx.application.Application;
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

public class NumberConverter extends Application {

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

    @Override
    public void start(Stage stage) throws Exception {

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

        stage.setTitle("NumberConverter");
        stage.setScene(new Scene(rootPane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
