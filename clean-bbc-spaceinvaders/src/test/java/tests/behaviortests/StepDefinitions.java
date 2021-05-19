package tests.behaviortests;

import common.BaseStepDefinitions;
import common.Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;
import spaceinvaders.sound.SoundEffectType;
import spaceinvaders.images.ImageType;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.gameobjects.Bomb;
import spaceinvaders.game.gameobjects.Spaceship;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions extends BaseStepDefinitions {

    @Override
    public void start(Stage stage) {
        this.stage = stage;
    }

    @Before
    public void beforeEach() {
        super.beforeEach();
    }

    @After
    public void afterEach() {
        super.afterEach();
    }

    @ParameterType(".*")
    public String someString(String string) {
        return string;
    }

    @Angenommen("die Spielfiguren sind maninipuliert und das Spiel kann nicht verloren oder gewonnen werden")
    public void dieSpielfigurenSindManinipuliertDieUndDasSpielKannNichtVerlorenOderGewonnenWerden() {
        hacker.useFakeGameObject();
        hacker.disableGameOverAndGameWonCheck();
    }

    @Angenommen("der Spieler startet die Applikation")
    public void derSpielerStartetDieApplikation() {
        app.setupAndStart();
    }

    @Angenommen("es existiert ein {someString} bei X={int}, Y={int}")
    @Angenommen("es existiert eine {someString} bei X={int}, Y={int}")
    public void esExistiertEinGameObjectBeiXY(String gameObjectType, int x, int y) {
        hacker.addGameObject(Util.getClassType(gameObjectType), x, y);
    }

    @Angenommen("der Spieler überwacht {someString}")
    public void instructHackerToObserve(String componentToObserve) {
        switch (componentToObserve) {
            case "die Musik" -> {
                hacker.spyFor(Sound.class);
            }
            case "die Navigation" -> {
                hacker.spyFor(Navigator.class);
            }
            case "das Laden der Bilder" -> {
                hacker.spyForImages();
            }
            default -> throw new IllegalStateException("Unexpected value: " + componentToObserve);
        }
    }

    @Wenn("der Spieler die {someString} Taste drückt")
    public void derSpielerDieSpaceTasteDrueckt(String pressedKey) {
        switch (pressedKey) {
            case "Space" -> {
                robot.press(KeyCode.SPACE);
            }
            case "linke Pfeil" -> {
                robot.press(KeyCode.LEFT);
            }
            case "rechte Pfeil" -> {
                robot.press(KeyCode.RIGHT);
            }
            default -> throw new IllegalStateException("Unexpected value: " + pressedKey);
        }
    }

    @Wenn("der Spieler auf den {someString} gelangt")
    public void navigateTo(String screenToNavigate) {
        hacker.navigatedTo(Util.getSceneType(screenToNavigate));
    }

    @Wenn("das {someString} zerstört wird")
    @Wenn("alle {someString}s zerstört werden")
    public void dasSpaceshipZerstoertWirdWerden(String gameObjectTypeToDestroy) {
        hacker.destroyAll(Util.getClassType(gameObjectTypeToDestroy));
    }

    @Wenn("der Spieler {int} Sekunden wartet")
    @Wenn("der Spieler {int} Sekunde wartet")
    public void derSpielerSekundeWartet(int timeToWaitInSeconds) throws InterruptedException {
        robot.sleep(timeToWaitInSeconds * 1000L);
    }

    @Dann("ist das Fenster {int} X {int} Pixel gross")
    public void assert_window_dimension(int expectedWidth, int excpectedHeight) {
        assertEquals(expectedWidth, stage.getWidth());
        assertEquals(excpectedHeight, stage.getHeight());
    }

    @Dann("lässt sich die Grösse des Fensters nicht verändern")
    public void window_is_not_resizable() {
        assertFalse(stage.isResizable());
    }

    @Dann("ist der Fenstertitel: {string}")
    public void istDerFenstertitelOfficiallyBbcSpaceInvaders(String windowTitle) {
        assertEquals(windowTitle, stage.getTitle());
    }

    @Dann("sieht der Spieler, dass {someString} geladen wurde")
    public void verify_that_the_image_loaded(String imageToObserve) {
        robot.sleep(2000);
        switch (imageToObserve) {
            case "der Introbackground" -> {
                hacker.verifyImagesLoad(ImageType.WELCOME_BACKGROUND);
            }
            case "der Gameoverbackground" -> {
                hacker.verifyImagesLoad(ImageType.GAME_OVER_BACKGROUND);
            }
            case "der Gamewonbackground" -> {
                hacker.verifyImagesLoad(ImageType.GAME_WON_BACKGROUND);
            }
            case "der Gamebackground" -> {
                hacker.verifyImagesLoad(ImageType.GAME_BACKGROUND);
            }
            default -> throw new IllegalStateException("Unexpected value: " + imageToObserve);
        }
    }

    @Dann("wird der {someString} abgespielt.")
    public void verfy_that_the_intro_background_music_plays(String soundToObserve) {
        switch (soundToObserve) {
            case "Introsoundtrack" -> {
                hacker.verifySoundPlay(MusicType.INTRO);
            }
            case "Gameoversoundtrack" -> {
                hacker.verifySoundPlay(SoundEffectType.SPACESHIP_EXPLODE);
            }
            default -> throw new IllegalStateException("Unexpected value: " + soundToObserve);
        }
    }

    @Dann("wird der Spieler zum {someString} weitergeleitet")
    public void verify_Navigator_NavigatedTo(String screenToNavigate) {
        hacker.verifyNavigatorNavigatedTo(Util.getSceneType(screenToNavigate));
    }

    @Dann("sieht der Spieler, dass {someString} {someString} angezeigt wird")
    @Dann("sieht der Spieler, dass {someString} {someString}s angezeigt werden")
    public void siehtDerSpielerDassSpaceshipAngezeigtWirdWerden(String amountOf, String gameObjectType) {
        double amountOfInDouble = amountOf.equals("einige") ? 0 : Double.parseDouble(amountOf);
        switch (gameObjectType) {
            case "SPACESHIP" -> {
                assertEquals(amountOfInDouble, hacker.getAmountOfGameObjectsFromType(Spaceship.class));
            }
            case "Aliens" -> {
                assertEquals(amountOfInDouble, hacker.getAmountOfGameObjectsFromType(Alien.class));
            }
            case "Bomben" -> {
                assertTrue(hacker.getAmountOfGameObjectsFromType(Bomb.class) > 0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + gameObjectType);
        }
    }

    @Dann("schwebt das {someString} mit einer Geschwindigkeit von {int} Pixel pro Sekunde nach {someString}")
    @Dann("schwebt der {someString} mit einer Geschwindigkeit von {int} Pixel pro Sekunde nach {someString}")
    public void schwebtDasGameObjectMitEinerGeschwindigkeitVonPixelProSekundeNachLinks(String gameObjectToObserve, int speed, String direction){
        double xFromSpaceship = hacker.getPositionFromGameObject(Util.getClassType(gameObjectToObserve))[0];
    }

    @Dann("befindet sich ein {someString} bei X={int}, Y={int}")
    public void befindetSichEinGameObjectBeiXY(String gameObjectType, int expectedX, int expectedY) {
        double[] actualPosition = hacker.getPositionFromGameObject(Util.getClassType(gameObjectType));

        assertEquals(actualPosition[0], expectedX);
        assertEquals(actualPosition[1], expectedY);
    }

    @Dann("bleibt das Spaceship am {someString} Rand.")
    public void bleibtDasSpaceshipAmLinkenRand(String position) {
        switch (position) {
            case "linken" -> {
                assertEquals(0, hacker.getPositionFromGameObject(Spaceship.class)[0]);
            }
            case "rechten" -> {
                assertEquals(800 - 50, hacker.getPositionFromGameObject(Spaceship.class)[0]);
            }
            default -> throw new IllegalStateException("Unexpected value: " + position);
        }
    }

    @Dann("wird das {someString} zerstört")
    public void wirdDasAlienZerstoert(String gameObjectType) {
        assertFalse(hacker.exitsGameObject(Util.getClassType(gameObjectType)));
    }
}