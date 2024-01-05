package ch.bbcag.bubblepop.game;

import ch.bbcag.bubblepop.Const;
import ch.bbcag.bubblepop.common.Navigator;
import ch.bbcag.bubblepop.game.gameobjects.Bubble;
import ch.bbcag.bubblepop.game.gameobjects.Paddle;
import ch.bbcag.bubblepop.gui.SceneType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import static ch.bbcag.bubblepop.Const.PADDLE_HEIGHT;
import static ch.bbcag.bubblepop.Const.PADDLE_WIDTH;

public class GameController {
    private final List<Bubble> bubbles;
    private final Navigator<SceneType> navigator;
    private final Runnable gameLoopStopper;
    private final KeyEventHandler keyEventHandler;
    private final Random random;
    private Paddle paddle;

    private int score;

    public GameController(KeyEventHandler keyEventHandler, Navigator<SceneType> navigator, Runnable gameLoopStopper) {
        this.keyEventHandler = keyEventHandler;
        this.navigator = navigator;
        this.bubbles = new CopyOnWriteArrayList<>();
        this.random = new Random();
        this.gameLoopStopper = gameLoopStopper;
    }

    public void load() {
        this.paddle = new Paddle(Const.PADDLE_START_X, Const.PADDLE_Y, keyEventHandler);
        this.score = 0;
    }

    public void update(double deltaInSec) {
        if (score >= Const.WIN_SCORE) {
            navigator.goTo(SceneType.GAME_WON);
            stop();
        }

        paddle.update(deltaInSec);

        if (random.nextDouble() < Const.BUUBBLE_SPAWN_PROBABILITY) {
            bubbles.add(new Bubble(random.nextDouble() * (Const.SCREEN_WIDTH - Bubble.DIAMETER), Const.BUBBLE_SPAWN_Y));
        }

        for (Bubble bubble : bubbles) {
            bubble.update(deltaInSec);

            if (bubble.getY() >= Const.SCREEN_HEIGHT - PADDLE_HEIGHT - bubble.getDiameter() &&
                    bubble.getX() + bubble.getDiameter() >= paddle.getX() &&
                    bubble.getX() <= paddle.getX() + PADDLE_WIDTH) {
                bubbles.remove(bubble);
                score++;
            } else if (bubble.getY() > Const.SCREEN_HEIGHT) {
                bubbles.remove(bubble);
            }

        }
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);

        paddle.draw(gc);

        for (Bubble bubble : bubbles) {
            bubble.draw(gc);
        }

        gc.setFill(Color.WHITE);
        gc.setFont(new Font(20)); //fontsize
        gc.fillText("Score: " + score, 10, 20); //margins
    }

    private void stop() {
        gameLoopStopper.run();
        bubbles.clear();
    }

}
