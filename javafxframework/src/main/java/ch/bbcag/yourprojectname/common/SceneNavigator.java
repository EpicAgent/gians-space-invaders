package ch.bbcag.yourprojectname.common;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneNavigator {
    
	private Stage stage;
	private Map<SceneType, Scene> sceneMap = new HashMap<>();

	public SceneNavigator(Stage stage) {
		this.stage = stage;
	}

	public void registerScene(SceneType key, Scene view) {
		sceneMap.put(key, view);
	}

	public void navigateTo(SceneType key) {
		stage.setScene(sceneMap.get(key));
		stage.show();
	}
	
	@SuppressWarnings("unchecked")
	public <T> void navigateTo(SceneType key, T arg) {
		Scene scene = sceneMap.get(key);
		((OneArgumentNavigatable<T>)scene).onNavigatedTo(arg);
		stage.setScene(scene);
		stage.show();
	}
}
