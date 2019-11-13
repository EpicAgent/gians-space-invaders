package praesi.car;


public class Car {
    private static final int SPEED = 10;
    private int x, y;

    public void onDownClick() {
        Direction dir = Direction.DOWN;
        setDirection(dir);
    }

    public void setDirection(Direction dir) {
        switch (dir) {
            case DOWN:
                y = -SPEED;
                break;
            case LEFT:
                x = +SPEED;
                break;
            case RIGHT:
                x = -SPEED;
                break;
            case UP:
                y = +SPEED;
                break;
            default:
                throw new IllegalStateException("Can't set direction " + dir.toString() + " to a car.");
        }
    }
}

