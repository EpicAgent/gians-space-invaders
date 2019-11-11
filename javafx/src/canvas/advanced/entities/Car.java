package canvas.advanced.entities;

import canvas.advanced.interfaces.Drawable;
import canvas.advanced.Input;
import canvas.advanced.interfaces.Updateable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Car extends Entity implements Updateable, Drawable {

    private Image carImage;
    private double carSpeed = 300;

    public Car(double x, double y) {
        super(x, y);

        this.carImage = new Image(getClass().getClassLoader().getResourceAsStream("assets_game/car_blue.png"));
    }

    @Override
    public void update(double deltaTime) {
        if (Input.isLeft()) {
            x -= deltaTime * carSpeed;
        }
        if (Input.isRight()) {
            x += deltaTime * carSpeed;
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(carImage, x, y);
    }
}
