package ch.bbcag.yourprojectname.view;

import ch.bbcag.yourprojectname.util.OneArgumentNavigatable;
import ch.bbcag.yourprojectname.SomeArgument;
import ch.bbcag.yourprojectname.util.SceneNavigator;
import ch.bbcag.yourprojectname.util.SceneType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class GameScene extends Scene implements OneArgumentNavigatable<SomeArgument> {

	private SceneNavigator sceneNavigator;
	private static Group rootNode = new Group();

	public GameScene(SceneNavigator sceneNavigator) {
		super(rootNode);
		this.sceneNavigator = sceneNavigator;
		buildScene();
	}

	// TODO example code must be replaced by own code
	private void buildScene() {
		Button button = new Button("Go to start scene");
		rootNode.getChildren().add(button);
		button.setOnAction(e ->	sceneNavigator.navigateTo(SceneType.START));
	}

	@Override
	public void onNavigatedTo(SomeArgument arg) {
		System.out.println("Yeah, we navigated with an argument!");
	}
}
