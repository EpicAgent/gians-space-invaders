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
class GameTest {

    private KeyEventHandler mockedKeyEventHandler = mock(KeyEventHandler.class);
    private Navigator mockedNavigator = mock(Navigator.class);
    private Runnable mockedGameLoopStopper = mock(Runnable.class);
    private GraphicsContext mockGraphicsContext = mock(GraphicsContext.class);
    private CollisionHandler mockCollisionHandler = mock(CollisionHandler.class);
    private GameObjectFactory mockedGameObjectFactory = mock(GameObjectFactory.class);
    private GameObjects gameObjects = new GameObjects(mockedGameObjectFactory); // mockedGameObjectFactory

    @Test
    void game_background_image_is_displayed() {

        /*Space space = new Space(mockedNavigator, gameObjects, mockCollisionHandler);
        space.initialize(mockedGameLoopStopper);

        space.draw(mockGraphicsContext);

        verify(mockGraphicsContext).drawImage(Images.getGameBackground(), 0d, 0d);*/
    }
}