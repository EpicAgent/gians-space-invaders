package common;

import javafx.stage.Stage;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import spaceinvaders.App;

public class BaseStepDefinitions extends ApplicationTest {

    protected Stage stage;
    protected HackedApp app;
    protected Hacker hacker;
    protected FxRobot robot;

    public BaseStepDefinitions() {
        try {
            launch(App.class, new String[]{}); // Das Framework TestFx muss App launchen.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void beforeEach() {
        try {
            super.internalBefore();
            hacker = new Hacker();
            app = new HackedApp(stage, hacker);
            // Die Verwendung der Variable robot in den StepDefinitions anstatt super macht den Code ausdruckstärker.
            robot = this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void afterEach() {
        try {
            super.internalAfter();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}