package lotr;

import java.util.Random;

import lotr.strategy.KickStrategy;
import lotr.strategy.NobleKickStrategy;

public class Noble extends Character{

    private static Random RANDOM = new Random();

    public Noble(int min_power, int max_power, int min_hp, int max_hp, KickStrategy kickStrategy) {

        super(RANDOM.nextInt(max_power-min_power) + min_power, 
        RANDOM.nextInt(max_hp-min_hp)+min_hp, new NobleKickStrategy());
    }

    @Override
    public void kick(Character enemy) {
        setHp(enemy.getHp());
    }

}
