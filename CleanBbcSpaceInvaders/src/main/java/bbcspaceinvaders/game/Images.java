package bbcspaceinvaders.game;

import javafx.scene.image.Image;

public class Images {

    public static final Image BOMB = getImage("images/bomb.png");
    public static final Image LASER = getImage("images/projectile.png");
    public static final Image ALIEN_SHIP = getImage("images/alienship.png");
    public static final Image SPACE_SHIP = getImage("images/spaceship.png");
    public static final Image GAME_BACKGROUND = getImage("images/background_game.png");
    public static final Image WELCOME_BACKGROUND = getImage("images/background_welcome.png");
    public static final Image GAME_OVER_BACKGROUND = getImage("images/background_gameover.png");
    public static final Image GAME_WON_BACKGROUND = getImage("images/background_mission_completed.png");

    private static Image getImage(String imagePath){
        return new Image(Images.class.getResourceAsStream("/" + imagePath));
    }
}
