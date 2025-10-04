package lotr.strategy;

import lotr.Character;

public abstract class KickStrategy {
    public abstract void kick(Character main, Character enemy);
}