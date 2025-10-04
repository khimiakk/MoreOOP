package lotr;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.Modifier;

import org.reflections.Reflections;

public class CharacterFactory {

    // public static Character createCharacter() {
    //     int randomNumber = new Random().nextInt(3);
    //     switch (randomNumber) {
    //         case 0:
    //             return new Hobbit();
    //         case 1:
    //             return new King();
    //         case 2:
    //             return new Knight();
    //         default:
    //             break;
    //     }
    //     return null;
    // }

    private static final Random random = new Random();

    private Character fallback() {
        return new Knight();
    }

    public Character createCharacter() {
        Reflections reflections = new Reflections("lotr");
        ArrayList<Class<? extends Character>> characterClasses = new ArrayList<>(reflections.getSubTypesOf(Character.class));
        characterClasses.removeIf(characterClass -> Modifier.isAbstract(characterClass.getModifiers()));
        int randomIndex = random.nextInt(characterClasses.size());
        try {
            Constructor<? extends Character> constructor = characterClasses.get(randomIndex).getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception ignore) {
            return fallback();
        }
    }
}

