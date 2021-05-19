package spaceinvaders.images;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Images {

    private static final Map<String, Image> cache = new HashMap<>();

    public static Image load(ImageType backgroundImage) {
        switch (backgroundImage) {
            case GAME_BACKGROUND -> { return loadFromCache("game_background.png"); }
            case WELCOME_BACKGROUND -> { return loadFromCache("welcome_background.png"); }
            case GAME_OVER_BACKGROUND -> { return loadFromCache("game_over_background.png"); }
            case GAME_WON_BACKGROUND -> { return loadFromCache("won_background.png"); }
            case LASER -> { return loadFromCache("laser.png"); }
            case BOMB -> { return loadFromCache("bomb.png"); }
            case SPACESHIP -> { return loadFromCache("spaceship.png"); }
            case ALIEN -> { return loadFromCache("alien.png"); }
        }

        throw new RuntimeException("Background-Image not found for: " + backgroundImage);
    }

    private static Image loadFromCache(String filename){
        if (!cache.containsKey(filename)) {
            cache.put(filename, new Image("/images/" + filename));
        }

        return cache.get(filename);
    }
}