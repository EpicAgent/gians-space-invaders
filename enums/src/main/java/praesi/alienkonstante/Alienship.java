package praesi.alienkonstante;

public class Alienship {
    private static final int SPEED = 10;
    private String currentDirection = Direction.RIGHT;
    private int xPosition = 0;

    public void moveInCurrentDirection() {
        if (currentDirection.equals(Direction.RIGHT)) {
            xPosition += SPEED;
        }
        if (currentDirection.equals(Direction.LEFT)) {
            xPosition -= SPEED;
        }
    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(String currentDirection) {
        this.currentDirection = currentDirection;
    }
}
