package spaceinvaders.common;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Lazy
@Component
public class Navigator<T> {

    private Stage stage;
    private final Map<T, Scene> viewMap = new HashMap<>();

    public Navigator(){
        System.out.printf("START");
    }

    public void registerScene(T enumScene, Scene scene) {
        viewMap.put(enumScene, scene);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void navigateTo(T scene) {
        Scene activeScene = viewMap.get(scene);

        if (viewMap.size() == 0) {
            return ;//throw new RuntimeException("Die Scene " + scene + " muss im Navigator registriert werden");
        }

        if (activeScene instanceof Initializable) {
            ((Initializable) activeScene).onInitialize();
        }

        // TODO
        /*if (stage == null) {
            return;
        }*/

        stage.setScene(activeScene);
        //stage.show();
    }
}