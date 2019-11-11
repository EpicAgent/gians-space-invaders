package ch.bbcag.yourprojectname.util;

import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;

public class Navigator {
    
	private Stage stage;
	private Map<ViewType, SceneProviderInterface> viewMap = new HashMap<ViewType, SceneProviderInterface>();

	public Navigator(Stage stage) {
		this.stage = stage;
	}

	public void registerView(ViewType key, SceneProviderInterface view) {
		viewMap.put(key, view);
	}

	public void switchToView(ViewType key) {
		stage.setScene(viewMap.get(key).getScene());
		stage.show();
	}
	
	@SuppressWarnings("unchecked")
	public <T> void switchToView(ViewType key, T arg) {
		
		SceneProviderInterface sceneProvider = viewMap.get(key);
		((OneArgumentReceiverInterface<T>)sceneProvider).calledWithArgument(arg);
		
		stage.setScene(sceneProvider.getScene());
		stage.show();
	}
}
