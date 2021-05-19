package spaceinvaders.game;

import javafx.scene.canvas.GraphicsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.common.FancyAnimationTimer;
import spaceinvaders.game.Space;

@Component
public class GameLoop extends FancyAnimationTimer {

    @Autowired
    @Lazy
    private Space space; // TODO
    private GraphicsContext gc;

    public void initialize(GraphicsContext gc){
        this.gc = gc;
    }

    @Override
    public void handle(double deltaInSec) {
        space.update(deltaInSec);
        space.draw(gc);
    }
}