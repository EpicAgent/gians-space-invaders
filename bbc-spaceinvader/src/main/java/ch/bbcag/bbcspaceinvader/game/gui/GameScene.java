package ch.bbcag.bbcspaceinvader.game.gui;

import ch.bbcag.bbcspaceinvader.common.Navigator;
import ch.bbcag.bbcspaceinvader.game.Const;
import ch.bbcag.bbcspaceinvader.game.KeyEventHandler;
import ch.bbcag.bbcspaceinvader.game.Sound;
import ch.bbcag.bbcspaceinvader.game.Space;
import ch.bbcag.bbcspaceinvader.game.enums.EnumSounds;
import ch.bbcag.bbcspaceinvader.interfaces.IInitializable;
import javafx.scene.CacheHint;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameScene extends Scene implements IInitializable {

	private static Group group = new Group();
	private GraphicsContext gc;
	private Navigator navigator;
	
	public GameScene(Navigator navigator) {
		super(group);
		
		this.navigator = navigator;
		
		Canvas canvas = new Canvas(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
		 
		group.getChildren().add(canvas);

		gc = canvas.getGraphicsContext2D();
		canvas.setCache(true);
		canvas.setCacheHint(CacheHint.SPEED);
		canvas.setDepthTest(DepthTest.ENABLE);
	}
	
	public void initialize() {
		
		Sound.start(EnumSounds.INTRO);
		KeyEventHandler keyEventHandler = new KeyEventHandler();

		this.setOnKeyPressed(keyEventHandler);
		this.setOnKeyReleased(keyEventHandler);
		
		Space space = new Space(keyEventHandler, gc, navigator);
		space.load();
		space.start();
   }
}
