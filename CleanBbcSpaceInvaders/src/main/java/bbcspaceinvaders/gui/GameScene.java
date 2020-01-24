package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.BaseScene;
import bbcspaceinvaders.common.Initializable;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.game.KeyEventHandler;
import bbcspaceinvaders.game.Space;
import javafx.scene.Group;

public class GameScene extends BaseScene implements Initializable {

    private static final Group root = new Group();

    public GameScene(Navigator navigator){
        super(navigator, root);
    }

    @Override
    public void onInitialize() {
        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Space space = new Space(keyEventHandler, createGraphicsContext(root), navigator);
        space.load();
        space.start();
    }
}
