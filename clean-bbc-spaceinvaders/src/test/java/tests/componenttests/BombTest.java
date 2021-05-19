package tests.componenttests;

import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.CollisionHandler;
import spaceinvaders.game.GameObjectFactory;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import spaceinvaders.game.GameObjects;

import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
class BombTest {

    private KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);
    private GameObjectFactory mockedGameObjectFactory = mock(GameObjectFactory.class);
    private GameObjects gameObjects = new GameObjects(mockedGameObjectFactory); // mockedGameObjectFactory

    @Test
    void bomb_fall_100_pixel_per_second() {

        int START_POSITION_BOMB = 0;
        int DISTANCE_TO_MOVE_IN_ONE_SECOND = 100;
        int FLYING_TIME_IN_SECONDS = 10;
        int FINAL_POSITION = START_POSITION_BOMB + (FLYING_TIME_IN_SECONDS * DISTANCE_TO_MOVE_IN_ONE_SECOND);

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);
        BOMB bomb = new BOMB(START_POSITION_BOMB, 0);
        gameObjects.add(bomb);
        space.update(FLYING_TIME_IN_SECONDS); // 10 Seconds x 100 Pixel = 1000 Pixel distance.
        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getBomb(), 0,  FINAL_POSITION);*/
    }
}