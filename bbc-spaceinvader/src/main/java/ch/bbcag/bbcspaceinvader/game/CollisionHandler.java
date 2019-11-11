package ch.bbcag.bbcspaceinvader.game;


import ch.bbcag.bbcspaceinvader.common.Util;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Alienship;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Bomb;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Laser;
import ch.bbcag.bbcspaceinvader.game.gameobjects.Spaceship;

public class CollisionHandler {

	private Space space;

	public CollisionHandler(Space space) {
		this.space = space;
	}

	public void handle() {
		handleForAlienWithLaser();
		handleForSpaceshipWithBombs();
		handleForLaserWithBomb();
	}

	private void handleForAlienWithLaser() {
		for (Laser shot : Util.getAllObjectsFromType(Laser.class, space)) {
			for (Alienship alien : Util.getAllObjectsFromType(Alienship.class, space)) {
				if (shot.collidesWith(alien)) {
					space.remove(alien);
				}
			}
		}
	}
	
	private void handleForSpaceshipWithBombs() {
		
		if (space.isSpaceshipDestroyed())
			return;
		
		Spaceship spaceship = space.getSpaceship();
		
		for (Bomb bomb : Util.getAllObjectsFromType(Bomb.class, space)) {
			if (bomb.collidesWith(spaceship)) {
				space.remove(spaceship);
			}
		}
	}
	
	private void handleForLaserWithBomb() {
		for (Laser shot : Util.getAllObjectsFromType(Laser.class, space)) {
			for (Bomb bomb : Util.getAllObjectsFromType(Bomb.class, space)) {
				if (shot.collidesWith(bomb)) {
					space.remove(bomb);
				}
			}
		}
	}
}
