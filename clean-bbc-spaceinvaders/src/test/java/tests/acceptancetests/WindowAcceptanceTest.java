package tests.acceptancetests;

import common.BaseAcceptanceTest;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.images.Images;
import spaceinvaders.sound.MusicType;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.sound.Sound;
import spaceinvaders.images.ImageType;
import spaceinvaders.common.Navigator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(ApplicationExtension.class)
class WindowAcceptanceTest extends BaseAcceptanceTest {

    @Start
    public void start(Stage stage) {
        super.setStage(stage);
    }

    @Test
    void window_size_is_800x600() {
        app.setupAndStart();

        assertEquals(800, stage.getWidth());
        assertEquals(600, stage.getHeight());
    }

    @Test
    void window_title_is_set() {
        app.setupAndStart();
        assertEquals("Officially Bbc SpaceInvaders", stage.getTitle());
    }

    @Test
    void window_is_not_resizable() {
        app.setupAndStart();
        assertEquals(false, stage.isResizable());
    }

    @Test
    public void intro_background_show(FxRobot robot) {
        try(MockedStatic<Images> imagesMockedStatic = mockStatic(Images.class)) {

            app.setupAndStart();

            imagesMockedStatic.verify(() -> Images.load(ImageType.WELCOME_BACKGROUND));
        }
    }

    @Test
    public void on_space_click_on_intro_then_spaceinvader_startsw(FxRobot robot) {
        // Arrange
        Navigator navigatorSpy = hacker.spyFor(Navigator.class);
        app.setupContext();

        // Act
        app.start();
        robot.sleep(100);
        robot.press(KeyCode.SPACE);
        robot.sleep(100);

        // Assert
        verify(navigatorSpy).navigateTo(SceneType.GAME);
    }

    @Test
    public void the_intro_background_music_plays(FxRobot robot) {
        // Arrange
        Sound soundSpy = hacker.spyFor(Sound.class);
        app.setupContext();

        // Act
        app.start();

        // Assert
        verify(soundSpy).play(MusicType.INTRO);
    }
}


























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