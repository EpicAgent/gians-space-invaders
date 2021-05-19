package common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.*;
import spaceinvaders.game.gameobjects.Spaceship;
import spaceinvaders.scenes.GameOverScene;
import spaceinvaders.scenes.GameScene;
import spaceinvaders.scenes.GameWonScene;
import spaceinvaders.scenes.WelcomeScene;
import spaceinvaders.sound.Sound;

import static org.mockito.Mockito.spy;

@Configuration
public class TestConfig {

    public TestConfig(){
        System.out.printf("asdf");
    }

    @Bean
    @Lazy
    public Navigator navigator() {
        Navigator navigator = new Navigator();
        /*if (stage == null){
            System.out.printf("Hey");
        }
        navigator.setStage(stage);*/
        return navigator;
    }

    @Bean
    @Lazy
    public Sound sound() {
        return new Sound();
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
        return spy(new GameObjectFactory());
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
}
