package spaceinvaders.scenes;

import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Initializable;
import spaceinvaders.common.Navigator;
import spaceinvaders.images.ImageType;
import spaceinvaders.images.Images;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;

@Component
public class WelcomeScene extends BaseScene implements Initializable {

    private final Sound sound;

    @Autowired
    public WelcomeScene(@Lazy Navigator<SceneType> navigator, Sound sound) {
        super(navigator, Images.load(ImageType.WELCOME_BACKGROUND));
        this.sound = sound;

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.navigateTo(SceneType.GAME);
            }
        });
    }

    @Override
    public void onInitialize() {
        sound.play(MusicType.INTRO);
    }
}
