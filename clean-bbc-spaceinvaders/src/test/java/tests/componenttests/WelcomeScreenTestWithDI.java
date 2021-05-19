package tests.componenttests;

import common.BaseComponentTest;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.Start;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.GameObjectFactory;
import spaceinvaders.game.Weapon;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.gameobjects.GameObject;
import spaceinvaders.game.gameobjects.Spaceship;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class WelcomeScreenTestWithDI extends BaseComponentTest {

    public WelcomeScreenTestWithDI(){
        System.out.println();
    }

    @Start
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Autowired
    @Lazy
    private Navigator navigator;

    @Autowired
    @Lazy
    private Spaceship spaceship;

    @Autowired
    @Lazy
    private Weapon weapon;

    @Test
    void gamescene_start(FxRobot robot) {

        GameObjectFactory gameObjectFactorySpy = context.getBean(GameObjectFactory.class);

        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(spaceship);
        gameObjects.add(new Alien(100, 100, weapon));
        when(gameObjectFactorySpy.create()).thenReturn(gameObjects);

        robot.sleep(2000);
        robot.press(KeyCode.SPACE);
        robot.sleep(500);
        robot.press(KeyCode.LEFT);
        robot.sleep(1000);
        assertTrue(spaceship.getX() <= 0);
    }

    @Test
    void gamescene_start2(FxRobot robot) {

        GameObjectFactory gameObjectFactorySpy = context.getBean(GameObjectFactory.class);

        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.add(spaceship);
        gameObjects.add(new Alien(100, 100, weapon));
        when(gameObjectFactorySpy.create()).thenReturn(gameObjects);

        robot.sleep(2000);
        robot.press(KeyCode.SPACE);
        robot.sleep(500);
        robot.press(KeyCode.LEFT);
        robot.sleep(1000);
        assertTrue(spaceship.getX() <= 0);
    }

/*
    @Test
    void gamescene_start_fly_right(FxRobot robot) {
        robot.sleep(2000);
        robot.press(KeyCode.SPACE);
        robot.sleep(500);
        robot.press(KeyCode.RIGHT);
        robot.sleep(1000);
        assertTrue(spaceship.getX() >= 0);
    }

    @Test
    void gamescene_start_fly_right2(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);

        robot.press(KeyCode.RIGHT);
        robot.sleep(4000);

        assertTrue(spaceship.getX() >= 0);
    }

    @Test
    void gamescene_start_fly_right4(FxRobot robot) {

        robot.sleep(100);
        robot.press(KeyCode.SPACE);

        robot.press(KeyCode.LEFT);
        robot.sleep(4000);

        assertTrue(spaceship.getX() >= 0);
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

 */
}