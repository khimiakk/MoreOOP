package lotr;

import lotr.strategy.NobleKickStrategy;

public class King extends Noble{

    public King () {
        super(5, 15, 5, 15, new NobleKickStrategy());
    }

}