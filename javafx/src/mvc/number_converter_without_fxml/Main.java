package mvc.number_converter_without_fxml;

import javafx.application.Application;
import javafx.stage.Stage;
import mvc.number_converter_without_fxml.controller.Controller;
import mvc.number_converter_without_fxml.model.Model;
import mvc.number_converter_without_fxml.view.View;

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
