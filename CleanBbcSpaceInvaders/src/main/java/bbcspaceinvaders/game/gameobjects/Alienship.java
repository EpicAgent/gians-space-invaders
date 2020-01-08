package bbcspaceinvaders.game.gameobjects;


import bbcspaceinvaders.game.Space;
import bbcspaceinvaders.gui.Direction;
import bbcspaceinvaders.main.Const;
import javafx.scene.canvas.GraphicsContext;

public class Alienship extends GameObject {

    private Direction direction = Direction.RIGHT;

    public Alienship(double x, double y, Space space){
        super(x, y, space, Const.ALIEN_SHIP_IMAGE);
    }

    @Override
    public void update(double deltaInSec) {
        moveInCurrentDirection(deltaInSec);
        changeDirectionIfNeeded();
        dropBomb(deltaInSec);
    }

    private void dropBomb(double deltaInSec){
        if (Math.random() < deltaInSec * Const.BOMB_DROP_CHANCE) {
            getSpace().add(new Bomb(getBoundingBox().getCenterX(), getBoundingBox().getMaxY(), getSpace()));
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        super.draw(gc);
    }

    private void moveInCurrentDirection(double deltaTimeInSec) {
        double distanceToMove = Const.SPEED_OF_ALIENSHIP * deltaTimeInSec;

        if (direction == Direction.RIGHT) {
            x+=distanceToMove;
        } else if (direction == Direction.LEFT) {
            x-=distanceToMove;
        }
    }

    private void changeDirectionIfNeeded() {
        if (getX() + getImage().getWidth() > Const.SCREEN_WIDTH) {
            direction = Direction.LEFT;
        }
        if (getX() < 0) {
            direction = Direction.RIGHT;
        }
    }

}
