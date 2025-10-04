package lotr.strategy;

import lotr.Character;

public class HobbitKickStrategy extends KickStrategy{
    @Override
    public void kick(Character main, Character enemy) {
        System.out.println("Cry a lot!");
    }
}