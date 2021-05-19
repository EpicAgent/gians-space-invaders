package common;

import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
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
import spaceinvaders.sound.Sound;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.mockito.Mockito.spy;
import static org.springframework.test.context.junit.jupiter.SpringExtension.getApplicationContext;

@ExtendWith(SpringExtension.class)
@ExtendWith(ApplicationExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration
public abstract class BaseComponentTest implements TestInstancePostProcessor, BeforeTestExecutionCallback, ApplicationContextAware {

    protected ApplicationContext context;
    protected Hacker hacker;
    protected Stage stage;
    private App app;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        hacker = applicationContext.getBean(Hacker.class);
        hacker.hack(applicationContext);
        context = applicationContext;
    }

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;

        app = new App();
        app.setApplicationContextForTesting(context);
        app.start(stage);
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context2) throws Exception {
        context = context;
        /*final Class<?> aClass = context.getTestClass().get();
        Optional<Object> testInstance1 = context.getTestInstance();
        Optional<Method> name = context.getTestMethod();
        System.out.println("asdf");//Logger logger = LogManager.getLogger(testInstance.getClass());
        //testInstance.getClass().getMethod("setLogger", Logger.class).invoke(testInstance, logger);*/
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        ApplicationContext applicationContext = getApplicationContext(extensionContext);
        Hacker hacker = applicationContext.getBean(Hacker.class);
        hacker.setTestMethodAnnotations(Util.extractAnnotationsOnTestClass(extensionContext));
    }


    @Configuration
    static class Config {

        @Bean
        @Lazy
        public Navigator navigator() {
            return hacker().getComponentOrFake(Navigator.class, new Navigator());
        }

        @Bean
        @Lazy
        public Sound sound() {
            return hacker().getComponentOrFake(Sound.class, new Sound());
        }

        @Bean
        @Lazy
        public KeyEventHandler keyEventHandler() {
            return hacker().getComponentOrFake(KeyEventHandler.class, new KeyEventHandler());
        }

        @Bean
        @Lazy
        public WelcomeScene welcomeScene() {
            return hacker().getComponentOrFake(WelcomeScene.class, new WelcomeScene(navigator(), sound()));
        }

        @Bean
        @Lazy
        public GameWonScene gameWonScene() {
            return hacker().getComponentOrFake(GameWonScene.class, new GameWonScene(navigator()));
        }

        @Bean
        @Lazy
        public GameOverScene gameOverScene() {
            return hacker().getComponentOrFake(GameOverScene.class, new GameOverScene(navigator(), sound()));
        }

        @Bean
        @Lazy
        public Weapon weapon() {
            return hacker().getComponentOrFake(Weapon.class, new Weapon(gameObjects()));
        }

        @Bean
        @Lazy
        public Spaceship spaceship() {
            return hacker().getComponentOrFake(Spaceship.class, new Spaceship(keyEventHandler(), weapon(), sound()));
        }

        @Bean
        @Lazy
        public GameObjects gameObjects() {
            return hacker().getComponentOrFake(GameObjects.class, new GameObjects(gameObjectFactory()));
        } //

        @Bean
        @Lazy
        public GameObjectFactory gameObjectFactory() {
            return hacker().getComponentOrFake(GameObjectFactory.class, new GameObjectFactory());
        }

        @Bean
        @Lazy
        public CollisionHandler collisionHandler() {
            return hacker().getComponentOrFake(CollisionHandler.class, new CollisionHandler(gameObjects()));
        }

        @Bean
        @Lazy
        public Space space() {
            return hacker().getComponentOrFake(Space.class, new Space(navigator(), gameObjects(), collisionHandler(), gameLoop(), sound()));
        }

        @Bean
        @Lazy
        public GameLoop gameLoop() {
            return hacker().getComponentOrFake(GameLoop.class, new GameLoop());
        }

        @Bean
        @Lazy
        public GameScene gameScene() {
            return hacker().getComponentOrFake(GameScene.class, new GameScene(navigator(), space(), gameLoop(), keyEventHandler()));
        }

        @Bean
        @Lazy
        public Hacker hacker() {
            return new Hacker();
        }
    }
}