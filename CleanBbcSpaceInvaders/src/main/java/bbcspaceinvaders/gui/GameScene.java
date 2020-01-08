package bbcspaceinvaders.gui;

import bbcspaceinvaders.common.GUIScene;
import bbcspaceinvaders.common.Navigator;
import bbcspaceinvaders.game.KeyEventHandler;
import bbcspaceinvaders.game.Space;
import javafx.scene.Group;

public class GameScene extends GUIScene {

    private static Group group = new Group();

    public GameScene(Navigator navigator){
        super(group, navigator);
    }

    @Override
    public void onOpen(){
        KeyEventHandler keyEventHandler = new KeyEventHandler();

        this.setOnKeyPressed(keyEventHandler);
        this.setOnKeyReleased(keyEventHandler);

        Space space = new Space(keyEventHandler, getGraphicsContext(), navigator);
        space.load();
        space.start();
    }

}
