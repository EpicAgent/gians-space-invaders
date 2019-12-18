package ch.bbcag.yourprojectname;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import ch.bbcag.yourprojectname.util.GlobalExceptionHandler;
import ch.bbcag.yourprojectname.util.SceneNavigator;
import ch.bbcag.yourprojectname.util.SceneType;
import ch.bbcag.yourprojectname.view.GameScene;
import ch.bbcag.yourprojectname.view.StartScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class YourProjectNameApplication extends Application {

	private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String LOG_FILE_NAME = "Log-File.txt";
	private static final int DEFAULT_STAGE_WIDTH = 800;
	private static final int DEFAULT_STAGE_HEIGHT = 600;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		setupExceptionHandling();
		setupStage(stage);

		SceneNavigator navigator = new SceneNavigator(stage);
		navigator.registerScene(SceneType.START, new StartScene(navigator));
		navigator.registerScene(SceneType.GAME, new GameScene(navigator));
		// Register all further scenes here

		navigator.navigateTo(SceneType.START); // Set default scene
	}

	// Don't touch unless you know what you do
	private void setupExceptionHandling() {
		
		// Register Global Exception Handler;
		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler(LOG_FILE_NAME);
		} catch (SecurityException | IOException e) {
			throw new RuntimeException(e);
		}
		
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		
		Thread.currentThread().setUncaughtExceptionHandler(new GlobalExceptionHandler(logger));
	}

	private void setupStage(Stage stage) {
		stage.setWidth(DEFAULT_STAGE_WIDTH);
		stage.setHeight(DEFAULT_STAGE_HEIGHT);
	}
}
