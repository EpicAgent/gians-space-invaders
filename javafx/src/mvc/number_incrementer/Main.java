package mvc.number_incrementer;

import javafx.application.Application;
import javafx.stage.Stage;

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
