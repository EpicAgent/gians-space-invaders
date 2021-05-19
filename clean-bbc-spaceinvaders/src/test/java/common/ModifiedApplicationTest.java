package common;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.application.HostServices;
import javafx.application.Preloader.PreloaderNotification;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationAdapter;
import org.testfx.framework.junit5.ApplicationFixture;

public abstract class ModifiedApplicationTest extends FxRobot implements ApplicationFixture {

    public static Application launch(Class<? extends Application> appClass, String... appArgs) throws Exception {
        FxToolkit.registerPrimaryStage();
        return FxToolkit.setupApplication(appClass, appArgs);
    }

    @BeforeEach
    public void internalBefore() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new ApplicationAdapter(this));
    }

    @AfterEach
    public final void internalAfter() throws Exception {
        // release all keys
        release(new KeyCode[0]);
        // release all mouse buttons
        release(new MouseButton[0]);
        FxToolkit.cleanupStages();
        FxToolkit.cleanupApplication(new ApplicationAdapter(this));
    }

    @Override
    public void init() throws Exception {}

    @Override
    public void start(Stage stage) throws Exception {}

    @Override
    public void stop() throws Exception {}

    @Deprecated
    public final HostServices getHostServices() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Parameters getParameters() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void notifyPreloader(PreloaderNotification notification) {
        throw new UnsupportedOperationException();
    }
}
