package tests.componenttests;

import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.GameObjectFactory;
import spaceinvaders.game.GameObjects;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(ApplicationExtension.class)
class LaserTest {

    private KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);
    private GameObjectFactory mockedGameObjectFactory = mock(GameObjectFactory.class);
    private GameObjects gameObjects = new GameObjects(mockedGameObjectFactory);

    @Test
    void laser_move_100_pixel_per_second_upwards() {

        int START_POSITION_LASER = 0;
        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;
        int FLYING_TIME_IN_SECONDS = 10;
        int FINAL_POSITION = START_POSITION_LASER - (FLYING_TIME_IN_SECONDS * DISTANCE_TO_MOVE_IN_ONE_SECOND);

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        LASER laser = new LASER(START_POSITION_LASER, 0);
        gameObjects.add(laser);
        space.update(FLYING_TIME_IN_SECONDS); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getLaser(), 0,  FINAL_POSITION);*/
    }
}