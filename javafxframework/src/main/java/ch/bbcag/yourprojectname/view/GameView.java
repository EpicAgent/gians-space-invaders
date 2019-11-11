package ch.bbcag.yourprojectname.view;

import ch.bbcag.yourprojectname.util.OneArgumentReceiverInterface;
import ch.bbcag.yourprojectname.SomeArgument;
import ch.bbcag.yourprojectname.util.Navigator;
import ch.bbcag.yourprojectname.util.SceneProviderInterface;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameView implements SceneProviderInterface, OneArgumentReceiverInterface<SomeArgument> {

	private Scene scene;
	private Navigator navigator;

	public GameView(Navigator navigator) {
		this.navigator = navigator;
		buildView();
	}

	// TODO example code must be replaced by own code
	private void buildView() {
		scene = new Scene(new Group());
	}
	
	// TODO remove runtime exception; return scene
	public Scene getScene() {

		// Test exception handling and logging
		throw new RuntimeException("Second scene not implemented yet");
	}

	@Override
	public void calledWithArgument(SomeArgument arg) {
		
	}
}
