package ch.bbcag.bbcspaceinvader.game;

import java.net.URL;

import ch.bbcag.bbcspaceinvader.game.enums.EnumSounds;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {

	private final static String soundFilePath = "/";
	// Idee für eine Demo des GarbageCollectors. Ist die MediaPlayer nicht in einer
	// Instance Variable gespeichert bricht der Sound
	// nach wenigen Sekunden ab, da der GarbageCollector ihn wegräumt.
	private static MediaPlayer player;

	public static void start(EnumSounds soundType) {

		if (player != null) {
			player.stop();
		}

		String filePath = soundFilePath + getSoundFileName(soundType);
		URL url = Sound.class.getResource(filePath);
		if (url == null) {
			throw new RuntimeException("Could not load file: " + filePath);
		}

		String path = Sound.class.getResource(filePath).toString();
		Media media = new Media(path);

		player = new MediaPlayer(media);
		player.play();
	}

	private static String getSoundFileName(EnumSounds soundType) {

		switch (soundType) {
		case GAMEOVER:
			return "GameOver.wav";
		case MISSION_COMPLETED:
			return "MissionCompleted.wav";
		case GAME_BACKGROUND:
			return "GameBackground.wav";
		case INTRO:
			return "Intro.mp3";

		default:
			throw new RuntimeException("No Soundfilename set for this enum value:" + soundType);
		}
	}
}
