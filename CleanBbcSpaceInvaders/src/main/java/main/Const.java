package bbcspaceinvaders.main;

import javafx.scene.image.Image;

public class Const {

    public static final double SCREEN_WIDTH = 800;
    public static final double SCREEN_HEIGHT = 600;
    public static final double SPACE_SHIP_Y = 480;
    public static final double BOMB_DROP_CHANCE = 0.2;
    public static final double LASER_SHOUT_TIME = 1;
    public static final double SPEED_OF_SPACESHIP = 100;
    public static final double SPEED_OF_LASER = 100;
    public static final double SPEED_OF_BOMB = 100;
    public static final double SPEED_OF_ALIENSHIP = 100;
    private final static Const instance = new Const();
    public static final Image BOMB_IMAGE = new Image(instance.getClass().getResourceAsStream("/bomb.png"));
    public static final Image LASER_IMAGE = new Image(instance.getClass().getResourceAsStream("/projectile.png"));
    public static final Image ALIEN_SHIP_IMAGE = new Image(instance.getClass().getResourceAsStream("/alienship.png"));
    public static final Image SPACE_SHIP_IMAGE = new Image(instance.getClass().getResourceAsStream("/spaceship.png"));
    public static final Image GAME_BACKGROUND_IMAGE = new Image(instance.getClass().getResourceAsStream("/background_game.png"));
    public static final Image WELCOME_BACKGROUND_IMAGE = new Image(instance.getClass().getResourceAsStream("/extra/background_welcome.png"));
    public static final Image GAME_OVER_BACKGROUND_IMAGE = new Image(instance.getClass().getResourceAsStream("/extra/background_gameover.png"));
    public static final Image GAME_WON_BACKGROUND_IMAGE = new Image(instance.getClass().getResourceAsStream("/extra/background_mission_completed.png"));
}
