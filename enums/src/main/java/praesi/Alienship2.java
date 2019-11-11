package praesi;

public class Alienship2 {
    private static final int SPEED = 10;
    private int currentDirection = 0;
    private int xPosition = 0;

    public void moveInCurrentDirection() {
        if (currentDirection == 1) {
            xPosition += SPEED;
        }
        if (currentDirection == -1) {
            xPosition -= SPEED;
        }
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
