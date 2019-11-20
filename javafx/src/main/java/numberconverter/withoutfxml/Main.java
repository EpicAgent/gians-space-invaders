package numberconverter.withoutfxml;

import javafx.application.Application;
import javafx.stage.Stage;
import numberconverter.withoutfxml.controller.Controller;
import numberconverter.withoutfxml.model.Model;
import numberconverter.withoutfxml.view.View;


public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller, model);

        stage.setScene(view.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
