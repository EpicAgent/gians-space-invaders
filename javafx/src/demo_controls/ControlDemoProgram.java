package demo_controls;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControlDemoProgram extends Application implements EventHandler<ActionEvent> {

	public static void main(String[] args) {
		launch(args);
	}

	private static final String[] DEMO_STRINGS = new String[] { "Marco Rohr", "Martin Hodler", "Mathias Rieder",
			"Yves Peissard" };

	private final Button btnButton = new Button("Button");
	private final Button btnTextField = new Button("TextField");
	private final Button btnComboBox = new Button("ComboBox");
	private final Button btnRadioButton = new Button("RadioButton");
	private final Button btnCheckBox = new Button("CheckBox");
	private final Button btnTextArea = new Button("TextArea");
	private final Button btnListView = new Button("ListView");
	private final Button btnTreeView = new Button("TreeView");
	private final Button btnProgressBar = new Button("ProgressBar");
	private final Button btnTableView = new Button("TableView");
	private final Button btnTreeTableView = new Button("TreeTableView");

	@Override
	public void start(Stage stage) throws Exception {

		FlowPane pneLayoutButtons = new FlowPane();
		pneLayoutButtons.setPadding(new Insets(10));
		pneLayoutButtons.setAlignment(Pos.CENTER);
		pneLayoutButtons.setHgap(4);
		pneLayoutButtons.setVgap(4);

		pneLayoutButtons.getChildren().addAll(btnButton, btnTextField, btnComboBox, btnRadioButton, btnCheckBox,
				btnTextArea, btnListView, btnTreeView, btnProgressBar, btnTableView, btnTreeTableView);

		btnButton.setOnAction(this);
		btnTextField.setOnAction(this);
		btnComboBox.setOnAction(this);
		btnRadioButton.setOnAction(this);
		btnCheckBox.setOnAction(this);
		btnTextArea.setOnAction(this);
		btnListView.setOnAction(this);
		btnTreeView.setOnAction(this);
		btnProgressBar.setOnAction(this);
		btnTableView.setOnAction(this);
		btnTreeTableView.setOnAction(this);

		Scene scene = new Scene(pneLayoutButtons, 480, 100);

		stage.setTitle("demo_layoutpane");
		stage.setScene(scene);
		stage.show();

	}

	private void showButtonDemo() {
		Button button = new Button("Button");

		showNode(button, "Button Demo");
	}

	private void showTextFieldDemo() {
		TextField textField = new TextField();
		textField.setPromptText("Placeholder");

		showNode(textField, "TextField Demo");
	}

	private void showComboBoxDemo() {
		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setPromptText("Wähle deinen Coach");
		comboBox.getItems().addAll(DEMO_STRINGS);

		showNode(comboBox, "ComboBox Demo");
	}

	private void showRadioButtonDemo() {
		RadioButton radioButton1 = new RadioButton(DEMO_STRINGS[0]);
		RadioButton radioButton2 = new RadioButton(DEMO_STRINGS[1]);
		RadioButton radioButton3 = new RadioButton(DEMO_STRINGS[2]);
		RadioButton radioButton4 = new RadioButton(DEMO_STRINGS[3]);

		ToggleGroup toggleGroup = new ToggleGroup();
		radioButton1.setToggleGroup(toggleGroup);
		radioButton2.setToggleGroup(toggleGroup);
		radioButton3.setToggleGroup(toggleGroup);
		radioButton4.setToggleGroup(toggleGroup);

		VBox box = new VBox(10, radioButton1, radioButton2, radioButton3, radioButton4);
		showNode(box, "RadioButton Demo");
	}

	private void showCheckBoxDemo() {
		CheckBox checkBox1 = new CheckBox(DEMO_STRINGS[0]);
		CheckBox checkBox2 = new CheckBox(DEMO_STRINGS[1]);
		CheckBox checkBox3 = new CheckBox(DEMO_STRINGS[2]);
		CheckBox checkBox4 = new CheckBox(DEMO_STRINGS[3]);

		VBox box = new VBox(10, checkBox1, checkBox2, checkBox3, checkBox4);
		showNode(box, "CheckBox Demo");
	}

	private void showTextAreaDemo() {
		TextArea textArea = new TextArea();
		textArea.setPromptText("Deine Nachricht");

		showNode(textArea, "TextArea Demo");
	}

	private void showListViewDemo() {
		ListView<String> listView = new ListView<>();
		listView.setOrientation(Orientation.VERTICAL);
		listView.getItems().addAll(DEMO_STRINGS);

		showNode(listView, "TextArea Demo");
	}

	private void showTreeViewDemo() {
		TreeItem<String> rootItem = new TreeItem<>("Coaches");

		for (String text : DEMO_STRINGS) {
			TreeItem<String> item = new TreeItem<>(text);
			rootItem.getChildren().add(item);
		}

		TreeView<String> treeView = new TreeView<>(rootItem);

		showNode(treeView, "TextArea Demo");
	}

	private void showProgressBarDemo() {
		ProgressBar progressBar = new ProgressBar();
		progressBar.setProgress(0.25f);

		showNode(progressBar, "ProgressBar Demo");
	}

	private void showTableViewDemo() {

		Person[] people = new Person[4];
		people[0] = new Person("Rohr", "Marco", "Zürich");
		people[1] = new Person("Hodler", "Martin", "Bern");
		people[2] = new Person("Rieder", "Mathias", "Zürich");
		people[3] = new Person("Peissard", "Yves", "Bern");

		TableView<Person> tableView = new TableView<>(FXCollections.observableArrayList(people));

		TableColumn<Person, String> colName = new TableColumn<Person, String>("Name");
		TableColumn<Person, String> colFirstName = new TableColumn<Person, String>("First Name");
		TableColumn<Person, String> colLastName = new TableColumn<Person, String>("Last Name");
		colName.getColumns().addAll(Arrays.asList(colFirstName, colLastName));

		TableColumn<Person, String> colLocation = new TableColumn<Person, String>("Location");
		tableView.getColumns().addAll(Arrays.asList(colName, colLocation));

		colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

		showNode(tableView, "TableView Demo");
	}

	private void showTreeTableViewDemo() {

		Person[] people = new Person[4];
		people[0] = new Person("Rohr", "Marco", "Zürich");
		people[1] = new Person("Hodler", "Martin", "Bern");
		people[2] = new Person("Rieder", "Mathias", "Zürich");
		people[3] = new Person("Peissard", "Yves", "Bern");

		TreeItem<Person> itmRoot = new TreeItem<>(new Person("root", "root", "root"));
		TreeItem<Person> itmMarco = new TreeItem<>(people[0]);
		TreeItem<Person> itmMartin = new TreeItem<>(people[1]);
		TreeItem<Person> itmMathias = new TreeItem<>(people[2]);
		TreeItem<Person> itmYves = new TreeItem<>(people[3]);

		itmMarco.getChildren().add(itmMathias);
		itmYves.getChildren().add(itmMartin);

		itmRoot.getChildren().addAll(Arrays.asList(itmYves, itmMarco));

		TreeTableView<Person> treeTableView = new TreeTableView<Person>(itmRoot);
		treeTableView.setShowRoot(false);

		TreeTableColumn<Person, String> colName = new TreeTableColumn<Person, String>("Name");
		TreeTableColumn<Person, String> colFirstName = new TreeTableColumn<Person, String>("First Name");
		TreeTableColumn<Person, String> colLastName = new TreeTableColumn<Person, String>("Last Name");
		colName.getColumns().addAll(Arrays.asList(colFirstName, colLastName));

		TreeTableColumn<Person, String> colLocation = new TreeTableColumn<Person, String>("Location");
		treeTableView.getColumns().addAll(Arrays.asList(colName, colLocation));

		colFirstName.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstName"));
		colLastName.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastName"));
		colLocation.setCellValueFactory(new TreeItemPropertyValueFactory<>("location"));

		showNode(treeTableView, "TableView Demo");

	}

	private void showNode(Node node, String windowTitle) {
		Stage stageFlowPane = new Stage();
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(20));

		pane.setCenter(node);

		Scene scene = new Scene(pane, 250, 250);
		stageFlowPane.setTitle(windowTitle);
		stageFlowPane.setScene(scene);
		stageFlowPane.show();
	}

	@Override
	public void handle(ActionEvent actionEvent) {

		if (actionEvent.getSource() == btnButton) {
			showButtonDemo();
		}
		if (actionEvent.getSource() == btnTextField) {
			showTextFieldDemo();
		}
		if (actionEvent.getSource() == btnComboBox) {
			showComboBoxDemo();
		}
		if (actionEvent.getSource() == btnRadioButton) {
			showRadioButtonDemo();
		}
		if (actionEvent.getSource() == btnCheckBox) {
			showCheckBoxDemo();
		}
		if (actionEvent.getSource() == btnTextArea) {
			showTextAreaDemo();
		}
		if (actionEvent.getSource() == btnListView) {
			showListViewDemo();
		}
		if (actionEvent.getSource() == btnTreeView) {
			showTreeViewDemo();
		}
		if (actionEvent.getSource() == btnProgressBar) {
			showProgressBarDemo();
		}
		if (actionEvent.getSource() == btnTableView) {
			showTableViewDemo();
		}
		if (actionEvent.getSource() == btnTreeTableView) {
			showTreeTableViewDemo();
		}
	}
}
