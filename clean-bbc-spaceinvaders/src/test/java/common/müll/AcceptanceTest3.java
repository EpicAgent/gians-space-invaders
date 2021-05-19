package common.müll;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(ApplicationExtension.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class AcceptanceTest3 {
/*
    @Configuration
    static class Config {

        @Bean
        public Navigator navigator() {
            return new Navigator();
        }

        @Bean
        public SPACESHIP spaceship() {
            return new SPACESHIP(keyEventHandler());
        }

        @Bean
        public KeyEventHandler keyEventHandler() {
            return new KeyEventHandler();
        }
    }

    private Stage stage;

    @Autowired
    private SPACESHIP spaceship;

    @Start
    public void start(Stage stage) {
        App tests.componenttests.app = new App();
        //tests.componenttests.app.context = setupApplicationContext();
        tests.componenttests.app.start(stage);
        this.stage = stage;
    }

    @Test
    void gamescene_start(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);

        robot.press(KeyCode.LEFT);
        robot.sleep(4000);

        assertTrue(spaceship.getX() <= 0);
    }*/
}