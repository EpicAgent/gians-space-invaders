package spaceinvaders.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class Sound {

    // Jede erstellte Instanz des MediaPlayer muss in einer Instancevariable/Klassenvariable gespeichert sein.
    // Sonst stoppt die der Sound sobald der Garbage Collector das Objekt im Speicher löscht.
    private MediaPlayer musicPlayer;
    private final Map<String, Media> cache = new HashMap<>();

    public void play(MusicType music) {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }

        musicPlayer = createMediaPlayer(getSoundFileName(music));
        musicPlayer.play();
    }

    public void play(SoundEffectType soundEffect) {
        MediaPlayer player = createMediaPlayer(getSoundFileName(soundEffect));
        player.play();
    }

    private MediaPlayer createMediaPlayer(String filePath) {
        filePath = "/sounds/" + filePath;

        if (!cache.containsKey(filePath)) {
            URL url = Sound.class.getResource(filePath);
            if (url == null) {
                throw new RuntimeException("Could not load file: " + filePath);
            }

            cache.put(filePath, new Media(url.toString()));
        }

        return new MediaPlayer(cache.get(filePath));
    }

    private String getSoundFileName(SoundEffectType soundEffect) {
        switch (soundEffect) {
            case LASER_FIRED:
                return "laser_fired.wav";
            case SPACESHIP_EXPLODE:
                return "explode_spaceship.wav";
            default:
                throw new RuntimeException("No sound-filename set for this enum. Value:" + soundEffect);
        }
    }

    private String getSoundFileName(MusicType music) {
        switch (music) {
            case BACKGROUND:
                return "music_ingame.wav";
            case INTRO:
                return "music_startscreen.wav";
            default:
                throw new RuntimeException("No sound-filename set for this enum. Value:" + music);
        }
    }
}