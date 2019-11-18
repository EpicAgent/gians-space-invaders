package layouts.teil1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TeamChat extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(25));

        HBox titleHbox = new HBox();
        Text title = new Text("Team Chat");
        HBox.setMargin(title, new Insets(0, 0, 25, 0));
        title.setFont(new Font("Helvetica", 20));
        titleHbox.getChildren().add(title);

        VBox vboxChatMessages = new VBox(10);
        vboxChatMessages.getChildren().add(generateChatEntry("Tschou zäme", true));
        vboxChatMessages.getChildren().add(generateChatEntry("Ciao", false));
        vboxChatMessages.getChildren().add(generateChatEntry("Sit er aui zwäg?", true));
        vboxChatMessages.getChildren().add(generateChatEntry("Ja eh, du?", false));

        TextArea textArea = new TextArea();
        textArea.setMaxHeight(100);
        VBox vboxTextArea = new VBox(10);
        VBox.setMargin(textArea, new Insets(25, 0, 0, 0));
        vboxTextArea.setAlignment(Pos.BOTTOM_RIGHT);
        vboxTextArea.getChildren().add(textArea);
        vboxTextArea.getChildren().add(new Button("Send"));


        root.setTop(titleHbox);
        root.setCenter(vboxChatMessages);
        root.setBottom(vboxTextArea);

        root.setPrefWidth(500);


        Scene scene = new Scene(root, 500, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    private HBox generateChatEntry(String text, boolean sentByMe) {
        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(7));
        hbox.setBackground(new Background(new BackgroundFill(Color.web("#d1e8ff"), new CornerRadii(10), Insets.EMPTY)));
        Text chatText = new Text(text);
        chatText.setFont(new Font("Helvetica", 14));
        Text timeText = new Text(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        timeText.setFont(new Font("Helvetica", 10));
        hbox.getChildren().add(chatText);
        hbox.getChildren().add(timeText);
        Pos pos;
        if (sentByMe) {
            pos = Pos.BASELINE_LEFT;
        } else {
            pos = Pos.BASELINE_RIGHT;
        }
        hbox.setAlignment(pos);

        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
