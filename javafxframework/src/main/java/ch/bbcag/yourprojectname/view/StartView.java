package ch.bbcag.yourprojectname.view;

import ch.bbcag.yourprojectname.SomeArgument;
import ch.bbcag.yourprojectname.util.Navigator;
import ch.bbcag.yourprojectname.util.SceneProviderInterface;
import ch.bbcag.yourprojectname.util.ViewType;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StartView implements SceneProviderInterface {
	
	private Scene scene;
	private Navigator navigator;
		
	public StartView(Navigator navigator) {
		this.navigator = navigator;
		buildScene();
	}
	
	// TODO example code must be replaced by own code
	private void buildScene() {
		Button button = new Button("Button scene 1");
		scene = new Scene(button);
		button.setOnAction(e ->	navigator.switchToView(ViewType.GAME, new SomeArgument()));
	}
	
	public Scene getScene() {
		return scene;
	}
}
