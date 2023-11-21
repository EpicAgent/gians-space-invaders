package ch.bbcag.bubblepop.game;

import javafx.scene.image.Image;

public class Images {
    public final static Image WELCOME_BACKGROUND = getImage("bubblepop_start.png");
    public final static Image GAME_WON_BACKGROUND = getImage("bubblepop_win.png");

    private static Image getImage(String imagePath) {
        return new Image("/images/" + imagePath);
    }

}
