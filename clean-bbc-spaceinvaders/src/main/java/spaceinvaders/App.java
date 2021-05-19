package spaceinvaders;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import spaceinvaders.game.Const;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.scenes.GameOverScene;
import spaceinvaders.scenes.GameScene;
import spaceinvaders.scenes.GameWonScene;
import spaceinvaders.scenes.WelcomeScene;
import spaceinvaders.common.Navigator;

public class App extends Application {

    @Autowired
    public ApplicationContext context;

    public void setApplicationContextForTesting(ApplicationContext context){
        this.context = context;
    }

    @Override
    public void init() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan(App.class.getPackage().getName());
        applicationContext.refresh();
        this.context = applicationContext;
    }

    @Override
    public void start(Stage stage) {
        setupGlobalExceptionHandler();
        setupStage(stage);
        setupNavigation(stage);
    }

    private void setupGlobalExceptionHandler() {
        // Only for Production
        /*
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
            LoggerFactory.getLogger(App.class).error("Unhandled exception:" + e);
            Platform.runLater(() -> {
                JOptionPane.showMessageDialog(null, "Something goes wrong!");
            });
        });
         */
    }

    private void setupStage(Stage stage) {
        stage.setTitle(Const.GAME_TITLE);
        stage.setWidth(Const.SCREEN_WIDTH);
        stage.setHeight(Const.SCREEN_HEIGHT);
        stage.setResizable(false);
        stage.show();
    }

    private void setupNavigation(Stage stage) {
        Navigator navigator = context.getBean(Navigator.class);
        navigator.setStage(stage);
        navigator.registerScene(SceneType.WELCOME, context.getBean(WelcomeScene.class));
        navigator.registerScene(SceneType.GAME, context.getBean(GameScene.class));
        navigator.registerScene(SceneType.GAME_OVER, context.getBean(GameOverScene.class));
        navigator.registerScene(SceneType.GAME_WON, context.getBean(GameWonScene.class));
        navigator.navigateTo(SceneType.WELCOME);
    }

    @Override
    public void stop() {
        //TODO Carefull cause context need to be open for testing.
        //this.context.close();
        //Platform.exit();
    }
}