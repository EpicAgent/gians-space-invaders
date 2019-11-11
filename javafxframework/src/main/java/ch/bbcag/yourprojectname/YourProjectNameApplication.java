package ch.bbcag.yourprojectname;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import ch.bbcag.yourprojectname.util.GlobalExceptionHandler;
import ch.bbcag.yourprojectname.util.Navigator;
import ch.bbcag.yourprojectname.util.ViewType;
import ch.bbcag.yourprojectname.view.GameView;
import ch.bbcag.yourprojectname.view.StartView;
import javafx.application.Application;
import javafx.stage.Stage;

public class YourProjectNameApplication extends Application {

	private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private final String fileName = "Log-File.txt";
	private Navigator navigator;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		setupExceptionHandling();
		
		navigator = new Navigator(stage);
		navigator.registerView(ViewType.START, new StartView(navigator));
		navigator.registerView(ViewType.GAME, new GameView(navigator));
		// Register all further scenes here

		navigator.switchToView(ViewType.START); // Set default scene
	}

	// Don't touch unless you know what you do
	private void setupExceptionHandling() {
		
		// Register Global Exception Handler;
		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler(fileName);
		} catch (SecurityException | IOException e) {
			throw new RuntimeException(e);
		}
		
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		
		Thread.currentThread().setUncaughtExceptionHandler(new GlobalExceptionHandler(logger));
	}
}
