package ch.bbcag.bbcspaceinvader;

import ch.bbcag.bbcspaceinvader.common.Navigator;
import ch.bbcag.bbcspaceinvader.game.enums.EnumScenes;
import ch.bbcag.bbcspaceinvader.game.gui.GameOverScene;
import ch.bbcag.bbcspaceinvader.game.gui.GameScene;
import ch.bbcag.bbcspaceinvader.game.gui.MissionCompletedScene;
import ch.bbcag.bbcspaceinvader.game.gui.WelcomeScene;
import javafx.application.Application;
import javafx.stage.Stage;


public class BbcSpaceInvaderApp extends Application {
	public static void main(String[] args) {
		BbcSpaceInvaderApp.launch(args);
	}

	@Override
	public void start(Stage stage)  {
		GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

		try {

			Navigator navigater = new Navigator(stage);
			navigater.registerScene(EnumScenes.WELCOME, new WelcomeScene(navigater));
			navigater.registerScene(EnumScenes.GAME, new GameScene(navigater));
			navigater.registerScene(EnumScenes.GAMEOVER, new GameOverScene(navigater));
			navigater.registerScene(EnumScenes.MISSION_COMPLETED, new MissionCompletedScene(navigater));

			navigater.setDefaultView(EnumScenes.WELCOME);
			
		} catch (Exception e) {
			globalExceptionHandler.uncaughtException(Thread.currentThread(), e);
		}
	}
}