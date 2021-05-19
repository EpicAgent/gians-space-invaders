package common.müll;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.App;
import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.GameObjects;
import spaceinvaders.game.gameobjects.Spaceship;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(ApplicationExtension.class)
//@RunWith(SpringRunner.class)
// ApplicationContext will be loaded from AppConfig and TestConfig
//@ContextConfiguration(classes = {AppConfig.class, TestConfig.class})
class AcceptanceTest2 {

    private static KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);

    private Stage stage;
    private Spaceship spaceship;

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

        applicationContext.registerBean(CollisionHandler.class, mockCollisionHandler);

        applicationContext.refresh();

        GameObjects gameObjects = applicationContext.getBean(GameObjects.class);

        gameObjects.removeIf(gameObject -> (gameObject instanceof Alien));

        spaceship = applicationContext.getBean(Spaceship.class);
        //gameObjects.add(spaceship);
        
        return applicationContext;
    }

    @Test
    void gamescene_start(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);

        robot.press(KeyCode.LEFT);
        robot.sleep(4000);

        assertTrue(spaceship.getX() <= 0);

        //Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        //space.initialize(mockedGameLoopStopper);

        //space.draw(mockGraphicsContext);

        //verify(mockGraphicsContext, times(14)).drawImage(eq(Images.getAlien()), anyDouble(), anyDouble());
    }

    @Test
    void gamescene_start2(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);

        robot.press(KeyCode.LEFT);
        robot.sleep(4000);

        assertTrue(spaceship.getX() <= 0);

        //Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        //space.initialize(mockedGameLoopStopper);

        //space.draw(mockGraphicsContext);

        //verify(mockGraphicsContext, times(14)).drawImage(eq(Images.getAlien()), anyDouble(), anyDouble());
    }
}