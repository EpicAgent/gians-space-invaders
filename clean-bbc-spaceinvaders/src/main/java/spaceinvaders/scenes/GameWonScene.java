package spaceinvaders.scenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.images.ImageType;
import spaceinvaders.images.Images;
import spaceinvaders.common.Navigator;
import javafx.scene.input.KeyCode;

@Component
public class GameWonScene extends BaseScene {

    @Autowired
    public GameWonScene(@Lazy Navigator navigator) {
        super(navigator, Images.load(ImageType.GAME_WON_BACKGROUND));

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.navigateTo(SceneType.WELCOME);
            }
        });
    }
}