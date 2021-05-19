package spaceinvaders.common;

import spaceinvaders.game.gameobjects.GameObject;

import java.util.List;

@FunctionalInterface
public interface Factory {
    List<GameObject> create();
}
