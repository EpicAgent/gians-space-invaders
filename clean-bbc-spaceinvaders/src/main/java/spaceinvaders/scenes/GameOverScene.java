package spaceinvaders.scenes;

import javafx.scene.input.KeyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Initializable;
import spaceinvaders.common.Navigator;
import spaceinvaders.images.ImageType;
import spaceinvaders.images.Images;
import spaceinvaders.sound.Sound;
import spaceinvaders.sound.SoundEffectType;

@Component
public class GameOverScene extends BaseScene implements Initializable {

    private Sound sound;

    @Autowired()
    public GameOverScene(@Lazy Navigator navigator, Sound sound) {
        super(navigator, Images.load(ImageType.GAME_OVER_BACKGROUND));
        this.sound = sound;

        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE){
                navigator.navigateTo(SceneType.WELCOME);
            }
        });
    }

    @Override
    public void onInitialize() {
        sound.play(SoundEffectType.SPACESHIP_EXPLODE);
    }
}
