package tests.componenttests;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.App;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class WindowTest {

    private Stage stage;

    @Start
    public void start(Stage stage) {
        App app = new App();
        app.context = setupApplicationContext();
        app.start(stage);
        this.stage = stage;
    }

    private AnnotationConfigApplicationContext setupApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan(App.class.getPackage().getName());
        applicationContext.refresh();
        return applicationContext;
    }

    @Test
    void window_size_is_800x600() {

        assertEquals(800, stage.getWidth());
        assertEquals(600, stage.getHeight());
    }

    @Test
    void window_title_is_set() {
        assertEquals("Officially Bbc SpaceInvaders", stage.getTitle());
    }

    @Test
    void window_is_not_resizable() {
        assertEquals(false, stage.isResizable());
    }
}