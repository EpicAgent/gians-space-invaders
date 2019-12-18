package ch.bbcag.yourprojectname.util;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GlobalExceptionHandler implements UncaughtExceptionHandler {

    private Logger logger;

    public GlobalExceptionHandler(Logger logger) {
        this.logger = logger;
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
