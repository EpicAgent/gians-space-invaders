package common;

import common.annotations.Mock;
import javafx.application.Platform;
import javafx.util.Pair;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import spaceinvaders.game.Space;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.images.ImageType;
import spaceinvaders.common.Factory;
import spaceinvaders.common.Navigator;
import spaceinvaders.game.GameObjectFactory;
import spaceinvaders.game.GameObjects;
import spaceinvaders.game.Weapon;
import spaceinvaders.game.gameobjects.*;
import spaceinvaders.images.Images;
import spaceinvaders.sound.MusicType;
import spaceinvaders.sound.Sound;
import spaceinvaders.sound.SoundEffectType;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@Component
public class Hacker {

    private List<Object> fakes = new ArrayList<>();

    private List<GameObject> fakeGameObjectsToInject = new ArrayList<>();
    private ApplicationContext context;
    private boolean hasFakedSpaceship = false;
    private boolean useFakedGameObjects = false;

    public void hack(ApplicationContext context) {
        this.context = context;
    }

    public void setTestMethodAnnotations(List<Pair<Class<?>, Annotation>> typesToFake) {
        for (Pair<Class<?>, Annotation> pair : typesToFake) {
            Object o = pair.getValue();
            if (o.toString().equals("MOCK")) {
                mockFor(pair.getKey());
            } else if (o.toString().equals("SPY")) {
                spyFor(pair.getKey());
            }
        }
    }

    public <T> T mockFor(Class<T> component) {
        T mock = mock(component);
        fakes.add(mock);
        return Util.getByType(fakes, component);
    }

    public <T> T mockPrivateFor(Class<T> component) {
        org.powermock.api.mockito.PowerMockito.spy(component);
        fakes.add(component);
        return Util.getByType(fakes, component);
    }

    public <T> T spyFor(Class<T> component) {
        T o = context.getBean(component);

        try {
            T spy = spy(o);
            fakes.add(spy);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return Util.getByType(fakes, component);
    }

    public <T> T getComponentOrFake(Class<T> componentType, T object) {
        if (Util.containsType(fakes, componentType)) {
            return Util.getByType(fakes, componentType);
        }
        return object;
    }

    public void setupGameObjectFactory() {
        // Falls keine GameObjekte zum faken gesetzt wurden, wird der origniale Componente verwendet.
        //TODO
        /*if (useFakedGameObjects) {
            context.registerBean(GameObjectFactoryForTesting.class);
        } else {
            context.registerBean(GameObjectFactory.class);
        }*/
    }

    public void disableGameOverAndGameWonCheck() {
        //GameObjects gameObjectsMock = Mockito.mock(GameObjects.class, CALLS_REAL_METHODS);
        //GameObjects gameObjects = new GameObjects(GameObjectFactoryForTesting.createOneSpaceshipNoWinCheck(context));
        //GameObjects gameObjectsMock = spy(gameObjects);
        //when(gameObjectsMock.mankindExterminated()).thenReturn(false);
        //when(gameObjectsMock.alienExterminated()).thenReturn(false);
        //mockAndSpyComponents.add(gameObjectsMock);
    }

    public void useFakeGameObject() {
        this.useFakedGameObjects = true;
    }

    public void replaceSpaceshipWithComponentIfNeeded() {
        if (fakeGameObjectsToInject != null || hasFakedSpaceship) {
            Spaceship spaceship = context.getBean(Spaceship.class);
            fakeGameObjectsToInject.add(spaceship);
        }
    }

    public void spyForImages() {
        // TODO
        throw new RuntimeException();
        //imagesMockedStatic = Mockito.mockStatic(Images.class);
    }

    public void verifyImagesLoad(ImageType imageType) {
        // TODO
        throw new RuntimeException();
        //imagesMockedStatic.verify(times(1), () -> Images.load(imageType));
    }

    public void verifySoundPlay(MusicType musicType) {
        verify(context.getBean(Sound.class)).play(musicType);
    }

    public void verifySoundPlay(SoundEffectType soundEffectType) {
        verify(context.getBean(Sound.class)).play(soundEffectType);
    }

    public void verifyNavigatorNavigatedTo(SceneType sceneType) {
        verify(context.getBean(Navigator.class), atLeastOnce()).navigateTo(sceneType);
    }

    public void navigatedTo(SceneType sceneType) {
        Platform.runLater(() -> {
            context.getBean(Navigator.class).navigateTo(sceneType);
        });
    }

    public <F extends T, T> void destroyAll(Class<T> typeToDelete) {
        Util.deleteAllObjectsFromType(typeToDelete, (List<T>) context.getBean(GameObjects.class));
    }

    public <F extends T, T> double getAmountOfGameObjectsFromType(Class<F> gameObjectType) {
        List<T> gameObjects = (List<T>) context.getBean(GameObjects.class);
        return (double) spaceinvaders.common.Util.getAllObjectsFromType(gameObjectType, gameObjects).stream().count();
    }

    public double[] getPositionFromGameObject(Class classType) {
        GameObject gameObject = (GameObject) context.getBean(classType);
        return new double[]{gameObject.getX(), gameObject.getY()};
    }

    public <F extends T, T> boolean exitsGameObjectAtPosition(Class spaceshipClass, int x, int y) {
        List<T> gameObjects = (List<T>) context.getBean(GameObjects.class);
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        gameObjects.forEach(gameObject -> {
            if (((GameObject) gameObject).getX() == x && ((GameObject) gameObject).getY() == y && spaceshipClass.isInstance(gameObject)) {
                result.set(true);
            }
        });

        return result.get();
    }

    public <F extends T, T> boolean exitsGameObject(Class spaceshipClass) {
        List<T> gameObjects = (List<T>) context.getBean(GameObjects.class);
        AtomicReference<Boolean> result = new AtomicReference<>(false);
        gameObjects.forEach(gameObject -> {
            if (spaceshipClass.isInstance(gameObject)) {
                result.set(true);
            }
        });

        return result.get();
    }

    public void addGameObject(Class gameObjectClass, int x, int y) {
        if (gameObjectClass == Laser.class) {
            fakeGameObjectsToInject.add(new Laser(x, y));
        } else if (gameObjectClass == Bomb.class) {
            fakeGameObjectsToInject.add(new Laser(x, y));
        } else if (gameObjectClass == Spaceship.class) {
            hasFakedSpaceship = true;
        } else if (gameObjectClass == Alien.class) {
            fakeGameObjectsToInject.add(new Alien(x, y, context.getBean(Weapon.class)));
        } else {
            throw new IllegalStateException("Unexpected value: " + gameObjectClass.getName());
        }
    }
}




            /*context.registerBean(Factory.class, () -> {
                Factory factory = mock(Factory.class);
                fakeGameObjectsToInject.add(new Alien(100, 100, null));
                fakeGameObjectsToInject.add(new Alien(200, 100, null));
                fakeGameObjectsToInject.add(new Alien(300, 100, null));

                when(factory.create()).thenReturn(fakeGameObjectsToInject);

                return factory;
            });*/