package bbcspaceinvaders.game;

import javafx.scene.image.Image;

public class Images {

    public static final Image BOMB_IMAGE = getImage("images/bomb.png");
    public static final Image LASER_IMAGE = getImage("images/projectile.png");
    public static final Image ALIEN_SHIP_IMAGE = getImage("images/alienship.png");
    public static final Image SPACE_SHIP_IMAGE = getImage("images/spaceship.png");
    public static final Image GAME_BACKGROUND_IMAGE = getImage("images/background_game.png");
    public static final Image WELCOME_BACKGROUND_IMAGE = getImage("images/background_welcome.png");
    public static final Image GAME_OVER_BACKGROUND_IMAGE = getImage("images/background_gameover.png");
    public static final Image GAME_WON_BACKGROUND_IMAGE = getImage("images/background_mission_completed.png");

    private static Image getImage(String imagePath){
        return new Image(Images.class.getResourceAsStream("/" + imagePath));
    }
}
