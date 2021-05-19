package tests.acceptancetests;

import common.BaseAcceptanceTest;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.game.Space;
import spaceinvaders.game.gameobjects.Spaceship;
import spaceinvaders.images.Images;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
//import static org.mockito.Mockito.*;

@ExtendWith(ApplicationExtension.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest
class GameAcceptanceTest extends BaseAcceptanceTest {

    @Start
    public void start(Stage stage) {
        super.setStage(stage);
    }

    @Test
    public void spaceship_fly_100_pixel_per_second_to_right(FxRobot robot) throws Exception {



        hacker.useFakeGameObject();
        //hacker.disableGameOverAndGameWonCheck(app.context);
        hacker.addGameObject(Spaceship.class, 400, 480);
        app.setupAndStart();

        Space spaceSpy = spy(app.context.getBean(Space.class));
        when(spaceSpy, "mankindExterminated").thenReturn(false);
        when(spaceSpy, "alienExterminated").thenReturn(false);

        hacker.navigatedTo(SceneType.GAME);
        robot.press(KeyCode.LEFT);
        robot.sleep(1000L);
        double[] actualPosition = hacker.getPositionFromGameObject(Spaceship.class);

        assertEquals(300, actualPosition[0]);
        assertEquals(480, actualPosition[1]);



        //PowerMockito.mockStatic(Images.class);
        //app.setupAndStart();
        // Act
        //robot.sleep(100);
        //robot.press(KeyCode.SPACE);
        //robot.sleep(100);

        //hacker.navigatedTo(SceneType.GAME);
        //robot.sleep(100);

        //Images.load(ImageType.GAME_BACKGROUND);
        // Assert
        //imagesMockedStatic.verify(() -> Images.getImage(ImageType.GAME_BACKGROUND), atLeastOnce());
    }

    /*@Test
    public void the_intro_background_music_plays(FxRobot robot) {
        // Arrange
        Sound soundSpy = hacker.spyFor(Sound.class);

        // Act
        app.setupAndStart();

        // Assert
        verify(soundSpy).play(MusicType.INTRO);
    }*/
}






/*
*
*
*
*
*             imagesMockedStatic.clearInvocations();
            imagesMockedStatic.when(Images::getGameBackground).thenReturn(null);
*
*
*
*
* */



















/*
    @Test
    void gameover(FxRobot robot) {

        Navigator navigatorSpy = spy(new Navigator());
        context.setMock(navigatorSpy);

        List<ALIEN> list = new ArrayList<>();
        //list.add(new ALIEN(100, 100, context.getBean(Gun.class)));
        //list.add(new ALIEN(200, 100, context.getBean(Gun.class)));
        CopyOnWriteArrayList<GameObject> aliens = new CopyOnWriteArrayList(list);


        GameObjects gameObjectsSpy = mock(GameObjects.class);
        when(gameObjectsSpy.getAlienShips()).thenReturn(list);
        doCallRealMethod().when(gameObjectsSpy).update(anyDouble());
        doCallRealMethod().when(gameObjectsSpy).draw(any(GraphicsContext.class));
        when(gameObjectsSpy.alienExterminated()).thenReturn(false);
        when(gameObjectsSpy.mankindExterminated()).thenReturn(false);
        when(gameObjectsSpy.iterator()).thenReturn(aliens.iterator());

        context.setMock(gameObjectsSpy);

        context.bind();

        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.sleep(100);

        //verify(navigatorSpy).navigateTo(SceneType.GAME);
    }


    /*


       @Test
    void gamescene_left_100perSec(FxRobot robot) {
        Navigator navigatorSpy = spy(new Navigator());
        mocks.add(navigatorSpy);
        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.LEFT);
        robot.sleep(1100);

        assertThat(context.getBean(SPACESHIP.class).getX()).isGreaterThan((Const.SCREEN_WIDTH / 2) - 100);
    }

    @Test
    void gamescene_right_100perSec(FxRobot robot) {
        init();
        robot.sleep(500);
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.RIGHT);
        robot.sleep(1000);

        assertThat(context.getBean(SPACESHIP.class).getX()).isLessThan(100);
    }


    @Test
    @Order(2)
    void gameOverScene_start(FxRobot robot) {

        gameObjects.getAlienShips().subList(0, gameObjects.getAlienShips().size() - 1).forEach(alien -> gameObjects.remove(alien));
        gameObjects.add(new BOMB(spaceship.getX(),spaceship.getY() - 100));
        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        robot.sleep(1000);

        Navigator navigatorSpy = this.context.getBean(Navigator.class);
        verify(navigatorSpy).navigateTo(SceneType.GAME_OVER);
    }


    @Test
    @Order(3)
    void gameWonScene_start(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        gameObjects.clear();
        robot.sleep(2000);
        Navigator navigatorSpy = this.context.getBean(Navigator.class);
        verify(navigatorSpy).navigateTo(SceneType.GAME_WON);
    }*/
            /*if (gac.containsBean("gameObjects")){
                try {
                    gac.removeBeanDefinition("gameObjects");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                gac.registerBean(GameObject.class, new GameObjects(gac.getBean(SPACESHIP.class))) ;
            }*/