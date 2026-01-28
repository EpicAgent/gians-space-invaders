package gianspaceinvaders.gui;

import gianspaceinvaders.common.BaseScene;
import gianspaceinvaders.common.FancyAnimationTimer;
import gianspaceinvaders.common.Initializable;
import gianspaceinvaders.common.Navigator;
import gianspaceinvaders.game.KeyEventHandler;
import gianspaceinvaders.game.MusicType;
import gianspaceinvaders.game.Sound;
import gianspaceinvaders.game.Space;

public class GameScene extends BaseScene implements Initializable {

    private FancyAnimationTimer gameLoop;

    public GameScene(Navigator<SceneType> navigator) {
        super(navigator);
    }

    @Override
    public void onInitialize() {

        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Sound.play(MusicType.BACKGROUND);

        Space space = new Space(keyEventHandler, navigator, () -> gameLoop.stop());
        space.load();

        gameLoop = new FancyAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                space.update(deltaInSec);
                space.draw(canvas.getGraphicsContext2D());
            }
        };
        gameLoop.start();
    }

}
