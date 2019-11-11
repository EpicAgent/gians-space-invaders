package ch.bbcag.bbcspaceinvader.game;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ch.bbcag.bbcspaceinvader.common.Navigator;
import ch.bbcag.bbcspaceinvader.common.Util;
import ch.bbcag.bbcspaceinvader.game.enums.EnumScenes;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Alienship;
import ch.bbcag.bbcspaceinvader.game.gameobjects.GameObject;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Spaceship;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;


@SuppressWarnings("serial")
public class Space extends CopyOnWriteArrayList<GameObject> {

	private KeyEventHandler keyEventHandler;
	private GraphicsContext gc;
	private CollisionHandler collisionHandler = new CollisionHandler(this);
	
	private long lastTimeInNanoSec;
	private Navigator navigator;
	
	public Space(KeyEventHandler keyEventHandler, GraphicsContext gc, Navigator navigator) {
		this.keyEventHandler = keyEventHandler;
		this.gc = gc;
		this.navigator = navigator;
	}
	
	public void load() {
		add(new Spaceship(this, keyEventHandler));
		add(new Alienship(300, 20, this));
		add(new Alienship(500, 20, this));
	}
	
	public void start() {
		lastTimeInNanoSec = System.nanoTime();
		
		AnimationTimer animationTimer = new AnimationTimer() {
			@Override
			public void handle(long currentTimeInNanoSec) {
				
				long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
				double deltaInSec = deltaInNanoSec / 1e9;;

				lastTimeInNanoSec = currentTimeInNanoSec;
			
				collisionHandler.handle();

				if (areAllAliensKilled()) {
					navigator.goTo(EnumScenes.MISSION_COMPLETED);
					stop();
				}
				
				if (isSpaceshipDestroyed()) { 
					navigator.goTo(EnumScenes.GAMEOVER);
					stop();
				}
				
				gc.clearRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
				for (GameObject gameObject : Space.this) {
					gameObject.update(deltaInSec);
					gameObject.draw(gc);
				}
			}
		};
				
		animationTimer.start();
	}
	
	private boolean areAllAliensKilled() {
		return Util.getAllObjectsFromType(Alienship.class, this).isEmpty();
	}
	
	public boolean isSpaceshipDestroyed() {
		return Util.getAllObjectsFromType(Spaceship.class, this).isEmpty();
	}
	
	public Spaceship getSpaceship() {
		List<Spaceship> spaceships = Util.getAllObjectsFromType(Spaceship.class, this);
		return spaceships.get(0);
	}
}