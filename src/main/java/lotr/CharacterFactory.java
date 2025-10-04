package lotr;

import java.lang.reflect.*;
import java.util.*;

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

    private static final List<Class<? extends Character>> characterClasses = Arrays.asList(
        Hobbit.class, Elf.class, King.class, Knight.class
    );

    private Character fallback() {
        return new Knight();
    }

    public Character createCharacter() {
        final Random random = new Random();
        
        int choice = random.nextInt(characterClasses.size());
        Class<? extends Character> characterClass = characterClasses.get(choice);

        try {
            Constructor<? extends Character> constructor = characterClass.getConstructor();
            return constructor.newInstance();
        } 
        catch (Exception e) {
            return fallback();
        }
    }
}
