package common;

import common.annotations.Mock;
import common.annotations.Spy;
import javafx.util.Pair;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import spaceinvaders.game.gameobjects.Alien;
import spaceinvaders.game.gameobjects.Bomb;
import spaceinvaders.game.gameobjects.Laser;
import spaceinvaders.game.gameobjects.Spaceship;
import spaceinvaders.scenes.SceneType;
import spaceinvaders.sound.Sound;
import spaceinvaders.common.Navigator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;

public class Util {

    public static List<Pair<Class<?>, Annotation>> extractAnnotationsOnTestClass(ExtensionContext testContext) {
        List<Pair<Class<?>, Annotation>> components = new ArrayList<>();
        components.addAll(extractAnnotationsOnTestClassInstanceFields(testContext));
        components.addAll(extractAnnotationsOnTestMethodParameters(testContext));
        return components;
    }

   private static List<Pair<Class<?>, Annotation>> extractAnnotationsOnTestClassInstanceFields(ExtensionContext testContext) {
        List<Pair<Class<?>, Annotation>> components = new ArrayList<>();
        Field[] fields = testContext.getTestClass().get().getDeclaredFields();
        for (Field field : fields){
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().getName().equals(Spy.class.getName())){
                    components.add(new Pair(field.getType(), MockType.SPY));
                }
                if (annotation.annotationType().getName().equals(Mock.class.getName())){
                    components.add(new Pair(field.getType(), MockType.MOCK));
                }
            }
        }

        return components;
    }

   private static List<Pair<Class<?>, Annotation>> extractAnnotationsOnTestMethodParameters(ExtensionContext testContext) {
       List<Pair<Class<?>, Annotation>> components = new ArrayList<>();
       Method method = testContext.getTestMethod().get();
       for(Parameter parameter : method.getParameters()) {
           for (Annotation annotation : parameter.getAnnotations()) {
               if (annotation.annotationType().getName().equals(Spy.class.getName())){
                   components.add(new Pair(parameter.getType(), MockType.SPY));
               }
               if (annotation.annotationType().getName().equals(Mock.class.getName())){
                   components.add(new Pair(parameter.getType(), MockType.MOCK));
               }
           }
       }

        return components;
    }

    public static boolean hasMockAnnotationOnParameter(ParameterContext parameterContext) {
        return parameterContext.isAnnotated(common.annotations.Mock.class);
    }

    public static boolean hasSpyAnnotationOnParameter(ParameterContext parameterContext) {
        return parameterContext.isAnnotated(common.annotations.Spy.class);
    }

    public static boolean checkIfMockFromType(Object mockObject, Class<?> searchedType){
        Class<?> typeToMock = mockingDetails(mockObject).getMockCreationSettings().getTypeToMock();
        return typeToMock == searchedType;
    }

    public static void threadSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static SceneType getSceneType(String screenToNavigate) {
        switch (screenToNavigate) {
            case "Gamescreen" -> {
                return SceneType.GAME;
            }
            case "Gameoverscreen" -> {
                return SceneType.GAME_OVER;
            }
            case "Gamewonscreen" -> {
                return SceneType.GAME_WON;
            }
            case "Introscreen" -> {
                return SceneType.WELCOME;
            }
            default -> throw new IllegalStateException("Unexpected value: " + screenToNavigate);
        }
    }

    public static Class getClassType(String nameOfType) {
        switch (nameOfType) {
            case "Alien" -> {
                return Alien.class;
            }
            case "Laser" -> {
                return Laser.class;
            }
            case "Bombe" -> {
                return Bomb.class;
            }
            case "Spaceship" -> {
                return Spaceship.class;
            }
            default -> throw new IllegalStateException("Unexpected value: " + nameOfType);
        }
    }

    public static Object getType(String componentToObserve) {
        switch (componentToObserve) {
            case "Musik" -> {
                return Sound.class;
            }
            case "Navigation" -> {
                return Navigator.class;
            }
            case "Bilder" -> {
                return Navigator.class;
            }

            default -> throw new IllegalStateException("Unexpected value: " + componentToObserve);
        }
    }

    public static <F extends T, T> void deleteAllObjectsFromType(Class<F> classToFind, List<T> list) {
            list.removeAll(spaceinvaders.common.Util.getAllObjectsFromType(classToFind, list));
    }

    public static <T> T getByType(List<Object> objects, Class<T> typeToMock) {
       for (Object o : objects){
           if (typeToMock.isInstance(o)){
               return (T)o;
           }
       }

       throw new RuntimeException("No object from type: " + typeToMock + "found");
    }

    public static <T> boolean containsType(List<Object> objects, Class<T> typeToMock) {
        for (Object o : objects){
            if (typeToMock.isInstance(o)){
                return true;
            }
        }

        return false;
    }
}