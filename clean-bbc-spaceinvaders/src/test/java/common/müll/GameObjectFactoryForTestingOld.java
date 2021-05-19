package common.müll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import spaceinvaders.common.Factory;
import spaceinvaders.game.Weapon;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.gameobjects.GameObject;
import spaceinvaders.game.gameobjects.Spaceship;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Component
public class GameObjectFactoryForTestingOld implements Factory {

    private ApplicationContext context;
    private Supplier<List<GameObject>> supplier;
    private Weapon weapon;

    @Autowired
    public GameObjectFactoryForTestingOld(Spaceship spaceship, Weapon weapon){
        supplier = () -> {
            List<GameObject> gameObjects = new ArrayList<>();
            gameObjects.add(spaceship);
            return gameObjects;
        };
        this.weapon = weapon;
    }

    public GameObjectFactoryForTestingOld(ApplicationContext context, Supplier<List<GameObject>> supplier) {
        this.context = context;
        this.supplier = supplier;
    }

    @Override
    public List<GameObject> create() {
        return supplier.get();
    }

    public static Factory createOneAlienAndOneSpaceship(ApplicationContext context) {
        return new GameObjectFactoryForTestingOld(context, () -> {
            List<GameObject> gameObjects = new ArrayList<>();
            gameObjects.add(new Alien(100, 20, context.getBean(Weapon.class)));
            gameObjects.add(context.getBean(Spaceship.class));
            return gameObjects;
        });
    }

    public static Factory createOneSpaceship(GenericApplicationContext context) {
        return new GameObjectFactoryForTestingOld(context, () -> {
            List<GameObject> gameObjects = new ArrayList<>();
            gameObjects.add(context.getBean(Spaceship.class));
            return gameObjects;
        });
    }

    public static Factory createOneSpaceshipNoWinCheck(GenericApplicationContext context) {
        return new GameObjectFactoryForTestingOld(context, () -> {
            List<GameObject> gameObjects = new ArrayList<>();
            gameObjects.add(context.getBean(Spaceship.class));
            return gameObjects;
        });
    }
}
