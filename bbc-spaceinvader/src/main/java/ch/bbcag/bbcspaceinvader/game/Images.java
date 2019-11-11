package ch.bbcag.bbcspaceinvader.game;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import ch.bbcag.bbcspaceinvader.game.enums.EnumImages;
import javafx.scene.image.Image;

public class Images {

	private final static String imageFilePath = "/";
	private static Map<EnumImages, Image> imageCache = new HashMap<EnumImages, Image>();

	public static Image load(EnumImages enumImages) {
		if (!imageCache.containsKey(enumImages)) {
			imageCache.put(enumImages, loadImage(getImageFileName(enumImages)));
		}

		return imageCache.get(enumImages);
	}

	private static String getImageFileName(EnumImages enumImages) {

		switch (enumImages) {
		case SPACESHIP:
			return "Spaceship.png";
		case ALIEN:
			return "Alienship.png";
		case LASER:
			return "Laser.png";
		case BOMB:
			return "Bomb.png";
		case BACKGROUND_STARTSCREEN:
			return "BackgroundStart.png";
		case BACKGROUND_GAMEOVER:
			return "BackgroundGameOver.png";
		case BACKGROUND_MISSION_COMPLETE:
			return "BackgroundMissionCompleted.png";
		default:
			throw new RuntimeException("No Filename set for this enum value!" + enumImages);
		}
	}

	private static Image loadImage(String fileName) {
		String filePath = imageFilePath + fileName;
		
		InputStream inputStream = Images.class.getResourceAsStream(filePath);
		
		if (inputStream == null) 
			throw new RuntimeException("Invalid Image path: " + filePath);
		
		return new Image(inputStream);
	}
}
