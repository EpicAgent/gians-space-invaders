package einstieg;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TeamCommenter extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootPane = new BorderPane();

        TreeItem<String> treeRoot = new TreeItem<>("Teams");
        TreeView<String> treeView = new TreeView<>(treeRoot);
        treeView.setShowRoot(false);
        VBox vBoxLeft = new VBox();
        VBox vBoxCenter = new VBox(25);
        vBoxCenter.setPadding(new Insets(25));

        TextField searchText = new TextField();
        searchText.setFocusTraversable(false);
        searchText.setPromptText("Search...");

        VBox.setVgrow(treeView, Priority.ALWAYS);

        vBoxLeft.getChildren().add(searchText);
        vBoxLeft.getChildren().add(treeView);

        for (Team team : TeamDao.getTeams()) {
            TreeItem<String> teamItem = new TreeItem<>(team.getName());

            treeRoot.getChildren().add(teamItem);
            for (Person person : team.getMembers()) {
                teamItem.getChildren().add(new TreeItem<>(person.getFullName()));
            }
        }

        Text title = new Text();
        title.setText("Vorname Nachname");

        vBoxCenter.getChildren().add(title);
        title.setFont(Font.font("Helvetica", 20));


        TextArea description = new TextArea();
        description.setPromptText("Description");
        vBoxCenter.getChildren().add(description);
        VBox.setVgrow(description, Priority.ALWAYS);

        Button okButton = new Button("Save");

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        buttonBox.getChildren().add(okButton);
        vBoxCenter.getChildren().add(buttonBox);


        rootPane.setCenter(vBoxCenter);
        rootPane.setLeft(vBoxLeft);

        treeView.getFocusModel().focus(0);
        treeView.getSelectionModel().select(0);


        primaryStage.setScene(new Scene(rootPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
