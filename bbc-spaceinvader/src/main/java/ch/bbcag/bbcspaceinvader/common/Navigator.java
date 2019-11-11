package ch.bbcag.bbcspaceinvader.common;

import java.util.HashMap;
import java.util.Map;

import ch.bbcag.bbcspaceinvader.game.enums.EnumScenes;
import ch.bbcag.bbcspaceinvader.interfaces.IInitializable;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Navigator {
    
	private Stage stage;
	private Map<EnumScenes, Scene> viewMap = new HashMap<EnumScenes, Scene>();

	public Navigator(Stage stage) {
		this.stage = stage;
	}

	public void registerScene(EnumScenes key, Scene scene) {
		viewMap.put(key, scene);
	}

	public void setDefaultView(EnumScenes key) {
		goTo(key);
	}
	
	public void goTo(EnumScenes key) {
		
		if (!viewMap.containsKey(key)) 
			throw new RuntimeException("You try to switch to an unknown Scene: '" + key + "'. Please call first the registerScene()-Method.");
		
		Scene scene = viewMap.get(key);
		
		if (scene instanceof IInitializable)
			((IInitializable)scene).initialize();
		
		stage.setScene(scene);
		stage.show();
	}
}