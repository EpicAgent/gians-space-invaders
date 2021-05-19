package tests.componenttests;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.App;
import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.Weapon;
import javafx.scene.canvas.GraphicsContext;
import spaceinvaders.game.GameObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
class AlienTest {

    private static KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private static Weapon mockedWeapon = mock(Weapon.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);

    private Stage stage;
    private static GameObjects gameObjects;

    @Start
    public void start(Stage stage) {
        App app = new App();
        app.context = setupApplicationContext();
        app.start(stage);
        this.stage = stage;

        // Die Klasse GameObjects kann nur initialisiert werden, wenn FX Graphics geladen ist.
        //gameObjects = new GameObjects(new SPACESHIP(mockedKeyEventHandler, mockedGun));
        //gameObjects.clear();
    }

    private AnnotationConfigApplicationContext setupApplicationContext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan(App.class.getPackage().getName());
        applicationContext.refresh();
        return applicationContext;
    }

    @Test
    void _14_aliens_are_displayed() {

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);

        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext, times(14)).drawImage(eq(Images.getAlien()), anyDouble(), anyDouble());*/
    }

    @Test
    void alien_is_flying_100_pixel_right_in_one_second() {

        int START_POSITION_ALIEN = 100;
        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;
        int FINAL_POSITION = START_POSITION_ALIEN + DISTANCE_TO_MOVE_IN_ONE_SECOND;

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        //ALIEN alien = new ALIEN(START_POSITION_ALIEN, 0, context.getBean(Gun.class)));
        //gameObjects.add(alien);

        space.update(1);
        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getAlien(), FINAL_POSITION, 0);*/
    }

    @Test
    void alien_change_direction_at_the_border_left() {

        when(mockedKeyEventHandler.isLeftKeyPressed()).thenReturn(true);
        //when(mockCollisionHandler.handle());

        int START_POSITION_ALIEN = 500;
        int SCREEN_WIDTH = 600;
        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;
        int FLYING_TIME_IN_SECONDS = 2;
        int FINAL_POSITION = START_POSITION_ALIEN + (FLYING_TIME_IN_SECONDS * DISTANCE_TO_MOVE_IN_ONE_SECOND) - SCREEN_WIDTH;

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);

        gameObjects.clear();
        //ALIEN alien = new ALIEN(START_POSITION_ALIEN, 0, context.getBean(Gun.class)));
        //gameObjects.add(alien);
        //gameObjects.add(new SPACESHIP(mockedKeyEventHandler));

        space.update(FLYING_TIME_IN_SECONDS); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), 0, FINAL_POSITION);*/
    }

    @Test
    void alien_change_direction_at_the_border_right() {

        int START_POSITION_ALIEN = 0;
        int SCREEN_WIDTH = 600;
        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;
        int FLYING_TIME_IN_SECONDS = 13;
        int FINAL_POSITION = START_POSITION_ALIEN + (FLYING_TIME_IN_SECONDS * DISTANCE_TO_MOVE_IN_ONE_SECOND) / SCREEN_WIDTH;

        // The ALIEN should move in 13 Seconds once the Screen and stop at Position 100

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        //ALIEN alien = new ALIEN(START_POSITION_ALIEN, 0, context.getBean(Gun.class)));
        //gameObjects.add(alien);
        //gameObjects.add(new SPACESHIP(mockedKeyEventHandler));
        space.update(FLYING_TIME_IN_SECONDS); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        // TODO Mock away the collisionHandler
        //verify(mockGraphicsContext).drawImage(Images.getSpaceship(), 0,  FINAL_POSITION);*/
    }
}