package lotr;

public class GameManager {

    public void startBattle(Character fighter1, Character fighter2) {
        System.out.println("Battle begins: " + fighter1 + " vs " + fighter2);

        int rounds = 0;
        final int MAX_ROUNDS = 100;

        while (fighter1.isAlive() && fighter2.isAlive() && rounds++ < MAX_ROUNDS) {

            fighter1.kick(fighter2);
            if (!fighter2.isAlive()) {
                System.out.println(fighter2 + " has fallen!");
                break;
            }

            fighter2.kick(fighter1);
            if (!fighter1.isAlive()) {
                System.out.println(fighter1 + " has fallen!");
                break;
            }
            }

        if (fighter1.isAlive() && fighter2.isAlive()) {
            System.out.println("Max rounds reached.");
        }
    System.out.println("The fight is over.");
}

    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        GameManager manager = new GameManager();

        Character fighter1 = factory.createCharacter();
        Character fighter2 = factory.createCharacter();

        if (fighter1 instanceof Elf && fighter2 instanceof Elf) {
            return;
        } else if (fighter1 instanceof Hobbit && fighter2 instanceof Hobbit) {
            return;
        } else {
            manager.startBattle(fighter1, fighter2);
        }
    }

}
