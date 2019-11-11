package demo_layoutpane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutPaneDemoProgram extends Application implements EventHandler<ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }


    private final Button btnFlowPane = new Button("FlowPane");
    private final Button btnStackPane = new Button("StackPane");
    private final Button btnAnchorPane = new Button("AnchorPane");
    private final Button btnGridPane = new Button("GridPane");
    private final Button btnTilePane = new Button("TilePane");
    private final Button btnScrollPane = new Button("ScrollPane");


    @Override
    public void start(Stage stage) throws Exception {

        FlowPane pneLayoutButtons = new FlowPane();
        pneLayoutButtons.setPadding(new Insets(10));
        pneLayoutButtons.setAlignment(Pos.CENTER);
        pneLayoutButtons.setHgap(4);

        pneLayoutButtons.getChildren().addAll(btnFlowPane, btnStackPane, btnAnchorPane, btnGridPane, btnTilePane, btnScrollPane);

        btnFlowPane.setOnAction(this);
        btnStackPane.setOnAction(this);
        btnAnchorPane.setOnAction(this);
        btnGridPane.setOnAction(this);
        btnTilePane.setOnAction(this);
        btnScrollPane.setOnAction(this);

        Scene scene = new Scene(pneLayoutButtons, 480, 50);

        stage.setTitle("demo_layoutpane");
        stage.setScene(scene);
        stage.show();

    }


    private void showFlowPaneDemo() {
        Stage stageFlowPane = new Stage();
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL);

        Rectangle rect1 = new Rectangle(250,20);
        rect1.setFill(Color.RED);

        Rectangle rect2 = new Rectangle(300,100);
        rect2.setFill(Color.GREEN);

        Rectangle rect3 = new Rectangle(200,60);
        rect3.setFill(Color.BLUE);

        pane.getChildren().addAll(rect1, rect2, rect3);

        Scene scene = new Scene(pane, 600, 400);
        stageFlowPane.setTitle("FlowPane");
        stageFlowPane.setScene(scene);
        stageFlowPane.show();
    }

    private void showStackPaneDemo() {
        Stage stageStackPane = new Stage();
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);

        Rectangle rect1 = new Rectangle(300,300);
        rect1.setFill(Color.RED);

        Rectangle rect2 = new Rectangle(200,200);
        rect2.setFill(Color.GREEN);

        Rectangle rect3 = new Rectangle(100,100);
        rect3.setFill(Color.BLUE);

        pane.getChildren().addAll(rect1, rect2, rect3);

        Scene scene = new Scene(pane, 600, 400);
        stageStackPane.setTitle("StackPane");
        stageStackPane.setScene(scene);
        stageStackPane.show();
    }

    private void showAnchorPaneDemo() {
        Stage stageAnchorPane = new Stage();
        AnchorPane pane = new AnchorPane();

        Rectangle rect1 = new Rectangle(300,300);
        rect1.setFill(Color.RED);

        Rectangle rect2 = new Rectangle(200,200);
        rect2.setFill(Color.GREEN);

        Rectangle rect3 = new Rectangle(100,100);
        rect3.setFill(Color.BLUE);

        pane.getChildren().addAll(rect1, rect2, rect3);

        // Anker oben-links
        AnchorPane.setTopAnchor(rect1, 0d);
        AnchorPane.setLeftAnchor(rect1, 0d);

        // Anker oben-rechts
        AnchorPane.setTopAnchor(rect2, 0d);
        AnchorPane.setRightAnchor(rect2, 0d);

        // Anker unten-links
        AnchorPane.setBottomAnchor(rect3, 0d);
        AnchorPane.setLeftAnchor(rect3, 0d);


        Scene scene = new Scene(pane, 600, 400);
        stageAnchorPane.setTitle("AnchorPane");
        stageAnchorPane.setScene(scene);
        stageAnchorPane.show();
    }


    private void showGridPaneDemo() {
        Stage stageGridPane = new Stage();

        GridPane pane = new GridPane();
        pane.setGridLinesVisible(true); // Damit werden die Grid-Linien angezeigt

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4 (colspan 2)");
        Button button5 = new Button("5");

        // Die Buttons sollen sich auf die Spaltenbreite anpassen (automatische Breite)
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);
        button4.setMaxWidth(Double.MAX_VALUE);
        button5.setMaxWidth(Double.MAX_VALUE);

        // Hinzufügen der Elemente
        pane.addRow(0, button1, button2, button3);
        pane.add(button4, 0, 1);
        pane.add(button5, 2, 1);

        GridPane.setColumnSpan(button4, 2);

        // Definitionen der Spaltenbreiten
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(20);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(20);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(60);

        pane.getColumnConstraints().addAll(column1, column2, column3);

        Scene scene = new Scene(pane, 600, 400);
        stageGridPane.setTitle("GridPane");
        stageGridPane.setScene(scene);
        stageGridPane.show();
    }

    private void showTilePaneDemo() {
        Stage stageTilePane = new Stage();
        TilePane pane = new TilePane();

        // Die bevorzugen Tile-Grössen
        pane.setPrefTileWidth(100d);
        pane.setPrefTileHeight(60d);
        pane.setPrefColumns(2);

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");

        // Die Buttons sollen sich auf die Tile-Grösse anpassen (automatische Grösse)
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        button3.setMaxWidth(Double.MAX_VALUE);
        button4.setMaxWidth(Double.MAX_VALUE);
        button5.setMaxWidth(Double.MAX_VALUE);
        button1.setMaxHeight(Double.MAX_VALUE);
        button2.setMaxHeight(Double.MAX_VALUE);
        button3.setMaxHeight(Double.MAX_VALUE);
        button4.setMaxHeight(Double.MAX_VALUE);
        button5.setMaxHeight(Double.MAX_VALUE);

        pane.getChildren().addAll(button1, button2, button3, button4, button5);

        Scene scene = new Scene(pane, 200, 400);
        stageTilePane.setTitle("TilePane");
        stageTilePane.setScene(scene);
        stageTilePane.show();
    }

    private void showScrollPaneDemo() {
        Stage stageScrollPane = new Stage();

        ScrollPane pane = new ScrollPane();

        // Beispiel Inhalt
        TilePane pneRectangles = new TilePane();
        pneRectangles.setPrefTileWidth(100);
        pneRectangles.setPrefTileHeight(100);
        pneRectangles.setPrefColumns(2); // Damit nicht mehr als 2 Spalten gemacht werden
        pneRectangles.setHgap(20);
        pneRectangles.setVgap(20);

        for (int i = 0; i < 10; i++) {
            Rectangle rect = new Rectangle(100 - (i * 5), 100 - (i * 5));
            rect.setFill(Color.DARKGRAY);

            pneRectangles.getChildren().add(rect);
        }

        // Setzen des Inhaltes
        pane.setContent(pneRectangles);
        // Die vertikale Scrollbar soll immer angezeigt werden
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Scene scene = new Scene(pane, 240, 400);
        stageScrollPane.setTitle("ScrollPane");
        stageScrollPane.setScene(scene);
        stageScrollPane.show();
    }


    @Override
    public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btnFlowPane) {
            showFlowPaneDemo();
        }
        if (actionEvent.getSource() == btnStackPane) {
            showStackPaneDemo();
        }
        if (actionEvent.getSource() == btnAnchorPane) {
            showAnchorPaneDemo();
        }
        if (actionEvent.getSource() == btnGridPane) {
            showGridPaneDemo();
        }
        if (actionEvent.getSource() == btnTilePane) {
            showTilePaneDemo();
        }
        if (actionEvent.getSource() == btnScrollPane) {
            showScrollPaneDemo();
        }
    }
}
