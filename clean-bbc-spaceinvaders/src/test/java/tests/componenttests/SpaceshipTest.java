package tests.componenttests;

import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.GameObjectFactory;
import spaceinvaders.game.Weapon;
import spaceinvaders.game.GameObjects;
import spaceinvaders.game.gameobjects.Spaceship;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
class SpaceshipTest {

    private static final double SPACESHIP_START_POSITION_X = 400;
    private static final double SPACESHIP_START_POSITION_Y = 480;

    private KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);
    private Weapon mockedWeapon = mock(Weapon.class);
    private Spaceship mockedSpaceship = mock(Spaceship.class);
    private GameObjects gameObjects = new GameObjects(new GameObjectFactory()); //

    @Test
    void spaceship_is_displayed_at_start_position_x_400_y_480() {

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);

        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), SPACESHIP_START_POSITION_X, SPACESHIP_START_POSITION_Y);*/
    }

    @Test
    void spaceship_is_flying_100_pixel_left_when_key_arrow_left_stay_pressed() {

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        SPACESHIP spaceship = new SPACESHIP(mockedKeyEventHandler, mockedGun);
        gameObjects.add(spaceship);

        when(mockedKeyEventHandler.isLeftKeyPressed()).thenReturn(true);

        space.update(1);
        space.draw(mockGraphicsContext);

        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;

        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), SPACESHIP_START_POSITION_X - DISTANCE_TO_MOVE_IN_ONE_SECOND, SPACESHIP_START_POSITION_Y);

         */
    }

    @Test
    void spaceship_is_flying_100_pixel_right_when_key_arrow_right_stay_pressed() {
/*
        Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        SPACESHIP spaceship = new SPACESHIP(mockedKeyEventHandler, mockedGun);
        gameObjects.add(spaceship);

        when(mockedKeyEventHandler.isRightKeyPressed()).thenReturn(true);

        space.update(1);
        space.draw(mockGraphicsContext);

        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;

        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), SPACESHIP_START_POSITION_X + DISTANCE_TO_MOVE_IN_ONE_SECOND, SPACESHIP_START_POSITION_Y);
    */
    }

    @Test
    void spaceship_stop_at_the_border_left() {

        when(mockedKeyEventHandler.isLeftKeyPressed()).thenReturn(true);
/*
        Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        SPACESHIP spaceship = new SPACESHIP(mockedKeyEventHandler,mockedGun);
        gameObjects.add(spaceship);
        space.update(10); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), 0,  SPACESHIP_START_POSITION_Y);

 */
    }

    @Test
    void spaceship_stop_at_the_border_right() {
/*
        Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        SPACESHIP spaceship = new SPACESHIP(mockedKeyEventHandler, mockedGun);
        gameObjects.add(spaceship);

        when(mockedKeyEventHandler.isLeftKeyPressed()).thenReturn(true);

        space.update(10); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        space.draw(mockGraphicsContext);
        int SCREEN_WIDTH = 600;
        int SPACE_WIDTH = 58;
        int MAX_DISTANCE_RIGHT = SCREEN_WIDTH - SPACE_WIDTH;
        verify(mockGraphicsContext).drawImage(Images.getSpaceship(), MAX_DISTANCE_RIGHT,  SPACESHIP_START_POSITION_Y);

 */
    }
}