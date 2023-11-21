package ch.bbcag.bubblepop.gui;

import ch.bbcag.bubblepop.common.BaseScene;
import ch.bbcag.bubblepop.common.FancyAnimationTimer;
import ch.bbcag.bubblepop.common.Initializable;
import ch.bbcag.bubblepop.common.Navigator;
import ch.bbcag.bubblepop.game.Controller;
import ch.bbcag.bubblepop.game.KeyEventHandler;

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

        Controller controller = new Controller(keyEventHandler, navigator, () -> gameLoop.stop());
        controller.load();

        gameLoop = new FancyAnimationTimer() {
            @Override
            public void doHandle(double deltaInSec) {
                controller.update(deltaInSec);
                controller.draw(canvas.getGraphicsContext2D());
            }
        };
        gameLoop.start();
    }

}
