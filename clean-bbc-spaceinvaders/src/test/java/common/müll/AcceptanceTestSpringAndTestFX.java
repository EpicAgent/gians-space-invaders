package common.müll;

import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.App;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

@ExtendWith({SpringExtension.class, ApplicationExtension.class})
@ContextConfiguration
class AcceptanceTestSpringAndTestFX implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    App app;
    private Stage stage;

    @Start
    public void start(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
/*
    @BeforeEach
    public void beforeEach(){
        Platform.runLater(() -> {
            tests.componenttests.app = new App();
            GenericApplicationContext gac = new GenericApplicationContext(context);

            /*if (gac.containsBean("gameObjects")){
                try {
                    gac.removeBeanDefinition("gameObjects");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                gac.registerBean(GameObject.class, new GameObjects(gac.getBean(SPACESHIP.class))) ;
            }
            gac.refresh();

            tests.componenttests.app.context = gac;

            tests.componenttests.app.start(stage);
        });



    }

    private AnnotationConfigApplicationContext setupApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(App.class.getPackage().getName());
        context.refresh();
        return context;
    }

    @AfterEach
    public void afterEach(){
        /*Platform.runLater(() -> {
            tests.componenttests.app.stop();
        });*/
    }
/*
    @Configuration
    static class Config {
        @Bean
        public Navigator navigator() {
            Navigator navigatorSpy = spy(new Navigator());
            return navigatorSpy;
        }

        @Bean @Lazy
        public WelcomeScene welcomeScene() {
            return new WelcomeScene(navigator());
        }

        @Bean @Lazy
        public GameScene gameScene() {
            return new GameScene(navigator(), space(), keyEventHandler());
        }

        @Bean @Lazy
        public GameWonScene gameWonScene() {
            GameWonScene gameWonSceneSpy = spy(new GameWonScene(navigator()));
            return gameWonSceneSpy;
        }

        @Bean @Lazy
        public GameOverScene gameOverScene() {
            GameOverScene gameOverSceneSpy = spy(new GameOverScene(navigator()));
            return gameOverSceneSpy;
        }

        @Bean @Lazy
        public Space space() {
            return new Space(navigator(), gameObjects(), collisionHandler());
        }

        @Bean @Lazy
        public SPACESHIP spaceship() {
            return new SPACESHIP(keyEventHandler());
        }

        @Bean @Lazy
        public GameObjects gameObjects() {
            return new GameObjects(spaceship());
        }

        @Bean @Lazy
        public KeyEventHandler keyEventHandler() {
            return new KeyEventHandler();
        }

        @Bean @Lazy
        public CollisionHandler collisionHandler() {
            return new CollisionHandler(gameObjects());
        }
    }

    @Autowired @Lazy
    private GameObjects gameObjects;

    @Autowired @Lazy
    private SPACESHIP spaceship;

    @Mock @Lazy
    private GameOverScene gameOverScene;

    @Test
    @Order(1)
    void gamescene_left_100perSec(FxRobot robot) {
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.LEFT);
        robot.sleep(1500);
        assertTrue(spaceship.getX() <= (Const.SCREEN_WIDTH / 2) - 50);
    }

    @Test
    @Order(1)
    void gamescene_right_100perSec(FxRobot robot) {
        robot.press(KeyCode.SPACE);
        robot.press(KeyCode.RIGHT);
        robot.sleep(1500);
        assertTrue(spaceship.getX() <= (Const.SCREEN_WIDTH / 2) + 50);
    }*/


    /*
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