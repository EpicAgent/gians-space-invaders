package spaceinvaders.scenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.game.GameLoop;
import spaceinvaders.game.KeyEventHandler;
import spaceinvaders.common.Initializable;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.Space;

@Component
public class GameScene extends BaseScene implements Initializable {

    private GameLoop gameLoop;
    private Space space;
    private KeyEventHandler keyEventHandler;

    @Autowired
    public GameScene(@Lazy Navigator navigator, Space space, GameLoop gameLoop, KeyEventHandler keyEventHandler){
        super(navigator);
        this.space = space;
        this.gameLoop = gameLoop;
        this.keyEventHandler = keyEventHandler;
    }

    @Override
    public void onInitialize() {
        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        space.initialize();
        gameLoop.initialize(gc);
        gameLoop.start();
    }
}