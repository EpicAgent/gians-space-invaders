package ch.bbcag.bbcspaceinvader;

import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GlobalExceptionHandler implements UncaughtExceptionHandler {

	private final String fileName = "Logs.txt";
	private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	// Setup the ExceptionHandler correctly in JavaFX is a bit tricky ;-)
	public void initialize() {
		
		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler(fileName);
		} catch (SecurityException | IOException e) {
			throw new RuntimeException(e);
		}
		
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> Platform.runLater(() -> this.uncaughtException(t, e)));
		Thread.currentThread().setUncaughtExceptionHandler(this);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		logger.log(Level.INFO, e.getMessage(), e);
		showDialogWithDefaultErrorMessage();
	}

	private void showDialogWithDefaultErrorMessage() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Application Error");
		alert.setContentText("Sorry, something went wrong. If this occurs again, please contact the support.");
		alert.showAndWait();
	}
}
