package lotr.strategy;

import java.util.Random;
import lotr.Character;

public class NobleKickStrategy extends KickStrategy {

    private static final Random RANDOM = new Random();

    @Override
    public void kick(Character main, Character enemy) {
        int p = Math.max(0, main.getPower());
        if (p == 0) {
            return;
        }
        int damage = RANDOM.nextInt(p) + 1;
        enemy.setHp(enemy.getHp() - damage);
    }
}
