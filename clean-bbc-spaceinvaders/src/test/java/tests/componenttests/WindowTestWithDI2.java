package tests.componenttests;

import common.Hacker;
import common.SpringBootTestContextBootstrapperExtended;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import spaceinvaders.App;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.*;
import spaceinvaders.game.gameobjects.Spaceship;
import spaceinvaders.scenes.GameOverScene;
import spaceinvaders.scenes.GameScene;
import spaceinvaders.scenes.GameWonScene;
import spaceinvaders.scenes.WelcomeScene;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(ApplicationExtension.class)
@BootstrapWith(SpringBootTestContextBootstrapperExtended.class)
//@TestExecutionListeners({ MockitoTestExecutionListener.class, ResetMocksTestExecutionListener.class })
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class WindowTestWithDI2 implements ApplicationContextAware {

    private ApplicationContext context;
    private App app;

    @MockBean
    private Sound sound;
    private Stage stage;

    @Test
    void gamescene_start() { //
        assertNotNull(sound);

        //try {
        //    sound.play(MusicType.INTRO);
        //} catch (Exception ex) {
        //}

        verify(sound).play(MusicType.INTRO);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;

        app = new App();
        app.setApplicationContextForTesting(context);
    }

    @Configuration
    static class Config {
        @Bean
        @Lazy
        public Navigator navigator() {
            return new Navigator();
        }

        @Bean
        @Lazy
        public Sound sound() {
            Sound sound = new Sound();
            return sound;
        }

        @Bean
        @Lazy
        public KeyEventHandler keyEventHandler() {
            return new KeyEventHandler();
        }

        @Bean
        @Lazy
        public WelcomeScene welcomeScene() {
            return new WelcomeScene(navigator(), sound());
        }

        @Bean
        @Lazy
        public GameWonScene gameWonScene() {
            return new GameWonScene(navigator());
        }

        @Bean
        @Lazy
        public GameOverScene gameOverScene() {
            return new GameOverScene(navigator(), sound());
        }

        @Bean
        @Lazy
        public Weapon weapon() {
            return new Weapon(gameObjects());
        }

        @Bean
        @Lazy
        public Spaceship spaceship() {
            return new Spaceship(keyEventHandler(), weapon(), sound());
        }

        @Bean
        @Lazy
        public GameObjects gameObjects() {
            return new GameObjects(gameObjectFactory());
        } //

        @Bean
        @Lazy
        public GameObjectFactory gameObjectFactory() {
            return new GameObjectFactory();
        }

        @Bean
        @Lazy
        public CollisionHandler collisionHandler() {
            return new CollisionHandler(gameObjects());
        }

        @Bean
        @Lazy
        public Space space() {
            return new Space(navigator(), gameObjects(), collisionHandler(), gameLoop(), sound());
        }

        @Bean
        @Lazy
        public GameLoop gameLoop() {
            return new GameLoop();
        }

        @Bean
        @Lazy
        public GameScene gameScene() {
            return new GameScene(navigator(), space(), gameLoop(), keyEventHandler());
        }

        @Bean
        @Lazy
        public Hacker hacker() {
            return new Hacker();
        }
    }

    @Start
    public void start(Stage stage) throws Exception {
        //super.start(stage);
        this.stage = stage;
        app.start(stage);
    }
}
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
////@ExtendWith(ApplicationExtension.class)

// auto inject helloRepository Mock / InjectMocks   / private Sound sound = new Sound();
//@Mock
//@Autowired
//private GameLoop gameLoop;