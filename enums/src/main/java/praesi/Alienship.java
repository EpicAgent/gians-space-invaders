package praesi;

public class Alienship {
    private static final int SPEED = 10;
    private String currentDirection = "right";
    private int xPosition = 0;

    public void moveInCurrentDirection() {
        if (currentDirection.equals("right")) {
            xPosition += SPEED;
        }
        if (currentDirection.equals("left")) {
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
