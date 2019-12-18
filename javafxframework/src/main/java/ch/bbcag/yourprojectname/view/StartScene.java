package ch.bbcag.yourprojectname.view;

import ch.bbcag.yourprojectname.SomeArgument;
import ch.bbcag.yourprojectname.util.SceneNavigator;
import ch.bbcag.yourprojectname.util.SceneType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class StartScene extends Scene {
	private SceneNavigator navigator;
	private static Group rootNode = new Group();
		
	public StartScene(SceneNavigator navigator) {
		super(rootNode);
		this.navigator = navigator;
		buildScene();
	}
	
	// TODO example code must be replaced by own code
	private void buildScene() {
		Button button = new Button("Go to game scene");
		rootNode.getChildren().add(button);
		button.setOnAction(e ->	navigator.navigateTo(SceneType.GAME, new SomeArgument()));
	}

}
