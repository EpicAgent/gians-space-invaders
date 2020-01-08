package bbcspaceinvaders.common;

import javafx.animation.AnimationTimer;

public abstract class FancyAnimationTimer extends AnimationTimer {

    private long lastTimeInNanoSec;

    @Override
    public void start() {
        super.start();
        lastTimeInNanoSec = System.nanoTime();
    }

    @Override
    public final void handle(long currentTimeInNanoSec) {
        long deltaInNanoSec = currentTimeInNanoSec - lastTimeInNanoSec;
        double deltaInSec = deltaInNanoSec / 1e9;;

        doHandle(deltaInSec);

        lastTimeInNanoSec = currentTimeInNanoSec;

    }

    public abstract void doHandle(double deltaInSec);
}
