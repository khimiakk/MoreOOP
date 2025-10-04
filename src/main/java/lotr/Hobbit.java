package lotr;

import lotr.strategy.HobbitKickStrategy;

public class Hobbit extends Character{

    public Hobbit() {
        super(0, 3, new HobbitKickStrategy());
    }

}