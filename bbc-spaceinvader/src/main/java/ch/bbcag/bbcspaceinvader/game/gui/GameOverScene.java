package ch.bbcag.bbcspaceinvader.game.gui;

import ch.bbcag.bbcspaceinvader.common.Navigator;
import ch.bbcag.bbcspaceinvader.game.Const;
import ch.bbcag.bbcspaceinvader.game.Sound;
import ch.bbcag.bbcspaceinvader.game.enums.EnumScenes;
import ch.bbcag.bbcspaceinvader.game.enums.EnumSounds;
import ch.bbcag.bbcspaceinvader.interfaces.IInitializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;


public class GameOverScene extends Scene implements IInitializable {

	private static Group group = new Group();
	
	public GameOverScene(Navigator navigator) {
		super(group);

		Canvas canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image(this.getClass().getResourceAsStream("/BackgroundGameOver.png"));
		gc.drawImage(image, 0, 0);
		group.getChildren().add(canvas);

		this.setOnKeyPressed((e) -> { 
			if (e.getCode() == KeyCode.SPACE){
				navigator.goTo(EnumScenes.WELCOME);
			}
		});
	}
	
	public void initialize() {
		Sound.start(EnumSounds.GAMEOVER);
   }
}
