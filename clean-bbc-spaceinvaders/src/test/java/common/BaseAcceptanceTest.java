package common;

import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseAcceptanceTest {

    protected HackedApp app;
    protected Hacker hacker;
    protected Stage stage;

    protected void setStage(Stage stage) {
        this.stage = stage;
    }

    @BeforeEach
    public void beforeEach(){
        hacker = new Hacker();
        app = new HackedApp(stage, hacker);
        hacker.hack(app.context);
    }

    @AfterEach
    public void afterEach(){
        app.close();
    }
}