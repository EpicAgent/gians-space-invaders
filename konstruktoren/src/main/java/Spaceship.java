public class Spaceship {

    private int speed;
    private int posX;
    private int posY;

    public Spaceship(int speed) {
        this.speed = speed;
    }

    public Spaceship(int speed, int posX, int posY) {
        this(speed);
        this.posX = posX;
        this.posY = posY;
    }
}