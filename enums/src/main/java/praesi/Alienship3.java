package praesi;

public class Alienship3 {
    private static final int SPEED = 10;
    private Direction currentDirection = Direction.RIGHT;
    private int xPosition = 0;

    public void moveInCurrentDirection() {
        if (currentDirection == Direction.RIGHT) {
            xPosition += SPEED;
        }
        if (currentDirection == Direction.LEFT) {
            xPosition -= SPEED;
        }
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
}
